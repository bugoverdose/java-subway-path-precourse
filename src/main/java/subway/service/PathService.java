package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

import static subway.constants.ExceptionMessages.NOT_CONNECTED_EXCEPTION;
import static subway.utils.InputValidator.validateFindPathInput;
import static subway.view.InputView.*;
import static subway.view.OutputView.showPathInfo;

public class PathService {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    private final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public PathService() {
        initGraph(distanceGraph);
        initGraph(timeGraph);
    }

    private void initGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }

        for (Section section : SectionRepository.sections()) {
            DefaultWeightedEdge newEdge = graph.addEdge(section.getCurStation(), section.getNextStation());
            graph.setEdgeWeight(newEdge, section.getDistance());
        }
    }

    public void run() {
        boolean isSuccessful = false;
        while (!isSuccessful) {
            printPathViewMenu();
            String userChoice = requestUserChoiceInput();
            isSuccessful = selectStationMenuAction(userChoice);
        }
    }

    private boolean selectStationMenuAction(String userChoice) {
        if (userChoice.equals("1")) {
            return findPath(distanceGraph);
        }
        if (userChoice.equals("2")) {
            return findPath(timeGraph);
        }
        return userChoice.equals("B");
    }

    private boolean findPath(WeightedMultigraph graph) {
        try {
            List<Station> path = calculateMinimumPath(graph);
            printPathInfo(path);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Station> calculateMinimumPath(WeightedMultigraph graph) {
        String startStationName = requestStartStationInput();
        String endStationName = requestEndStationInput();
        validateFindPathInput(startStationName, endStationName);

        Station startStation = StationRepository.findByName(startStationName);
        Station endStation = StationRepository.findByName(endStationName);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        try {
            return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_CONNECTED_EXCEPTION);
        }
    }

    private void printPathInfo(List<Station> path) {
        int totalDistance = 0;
        int totalTime = 0;

        for (int index = 0; index <= path.size()-2; index++) {
            Station curStation = path.get(index);
            Station nextStation = path.get(index+1);
            Section section = SectionRepository.findBySectionByStations(curStation, nextStation);
            totalDistance += section.getDistance();
            totalTime += section.getTime();
        }
        showPathInfo(totalDistance, totalTime, path);
    }
}
