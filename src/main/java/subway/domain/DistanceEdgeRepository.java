package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static subway.domain.StationRepository.findByName;

public class DistanceEdgeRepository {

    private static final List<DistanceEdge> distanceEdges = new ArrayList<>();

    public static List<DistanceEdge> distanceEdges() {
        return Collections.unmodifiableList(distanceEdges);
    }

    private static void addDistanceEdge(DistanceEdge distanceEdges) {
        DistanceEdgeRepository.distanceEdges.add(distanceEdges);
    }

    public static void initDatabase() {
        addDistanceEdge(new DistanceEdge(findByName("교대역"), findByName("강남역"), 3));
        addDistanceEdge(new DistanceEdge(findByName("강남역"), findByName("역삼역"), 3));
        addDistanceEdge(new DistanceEdge(findByName("교대역"), findByName("남부터미널역"), 2));
        addDistanceEdge(new DistanceEdge(findByName("남부터미널역"), findByName("양재역"), 5));
        addDistanceEdge(new DistanceEdge(findByName("양재역"), findByName("매봉역"), 1));
        addDistanceEdge(new DistanceEdge(findByName("강남역"), findByName("양재역"), 8));
        addDistanceEdge(new DistanceEdge(findByName("양재역"), findByName("양재시민의숲역"), 3));
    }
}
