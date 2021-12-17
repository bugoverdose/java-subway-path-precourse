package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

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

        for (Line line : LineRepository.lines()) {
            for (Section section : line.getSections()) {
                DefaultWeightedEdge newEdge = graph.addEdge(section.getCurStation(), section.getNextStation());
                graph.setEdgeWeight(newEdge, section.getDistance());
            }
        }
    }

    public void run() {
        printPathViewMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("1")) {
                findPathByMinDistance();
            }
            if (userChoice.equals("2")) {
                findPathByMinTime();
            }
            if (userChoice.equals("B")) {
                break;
            }
        }
    }

    private void findPathByMinDistance() {
        List<Station> path = calculateMinimumPath(distanceGraph);
        printPathInfo(path);
    }

    private void findPathByMinTime() {
        List<Station> path = calculateMinimumPath(timeGraph);
        printPathInfo(path);
    }

    private List<Station> calculateMinimumPath(WeightedMultigraph graph) {
        Station startStation = StationRepository.findByName(requestStartStationInput());
        Station endStation = StationRepository.findByName(requestEndStationInput());

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    private void printPathInfo(List<Station> path) {
        int totalDistance = 0;
        int totalTime = 0;

        for (int index = 0; index <= path.size()-2; index++) {
            Station curStation = path.get(index);
            Station nextStation = path.get(index+1);
            Section section = LineRepository.findBySectionByStations(curStation, nextStation);
            totalDistance += section.getDistance();
            totalTime += section.getTime();
        }
        showPathInfo(totalDistance, totalTime, path);
    }
}
