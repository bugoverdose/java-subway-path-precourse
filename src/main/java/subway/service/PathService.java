package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.RouteGraph;

import java.util.List;

import static subway.constants.ExceptionMessages.NOT_CONNECTED_EXCEPTION;
import static subway.utils.InputValidator.*;
import static subway.view.InputView.*;
import static subway.view.OutputView.showPathInfo;

public class PathService {

    public void run() {
        boolean isSuccessful = false;
        while (!isSuccessful) {
            printPathViewMenu();
            String userChoice = requestUserChoiceInput();
            isSuccessful = selectPathMenuAction(userChoice);
        }
    }

    private boolean selectPathMenuAction(String userChoice) {
        try {
            validatePathMenuInput(userChoice);
            return runPathMenuAction(userChoice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean runPathMenuAction(String userChoice) {
        if (userChoice.equals("1")) {
            return findPath(RouteGraph.getDistanceGraph());
        }
        if (userChoice.equals("2")) {
            return findPath(RouteGraph.getTimeGraph());
        }
        return userChoice.equals("B");
    }

    private boolean findPath(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        try {
            List<Station> path = calculateMinimumPath(graph);
            printPathInfo(path);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Station> calculateMinimumPath(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        String startStationName = requestStartStationInput();
        String endStationName = requestEndStationInput();
        validateFindPathInput(startStationName, endStationName);

        Station startStation = StationRepository.findByName(startStationName);
        Station endStation = StationRepository.findByName(endStationName);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> path = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        validatePathConnection(path);
        return path;
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
