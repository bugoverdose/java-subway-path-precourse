package subway.utils;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class RouteGraph {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceGraph() {
        return distanceGraph;
    }

    public static WeightedMultigraph<Station, DefaultWeightedEdge> getTimeGraph() {
        return timeGraph;
    }

    public static void initRouteGraphs() {
        initGraph(distanceGraph);
        initGraph(timeGraph);
    }

    private static void initGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }

        for (Section section : SectionRepository.sections()) {
            DefaultWeightedEdge newEdge = graph.addEdge(section.getCurStation(), section.getNextStation());
            graph.setEdgeWeight(newEdge, section.getDistance());
        }
    }
}
