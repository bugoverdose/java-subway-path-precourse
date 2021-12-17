package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static subway.domain.StationRepository.findByName;

public class TimeEdgeRepository {

    private static final List<TimeEdge> timeEdges = new ArrayList<>();

    public static List<TimeEdge> timeEdges() {
        return Collections.unmodifiableList(timeEdges);
    }

    private static void addTimeEdge(TimeEdge timeEdge) {
        timeEdges.add(timeEdge);
    }

    public static void initDatabase() {
        addTimeEdge(new TimeEdge(findByName("교대역"), findByName("강남역"), 3));
        addTimeEdge(new TimeEdge(findByName("강남역"), findByName("역삼역"), 3));
        addTimeEdge(new TimeEdge(findByName("교대역"), findByName("남부터미널역"), 2));
        addTimeEdge(new TimeEdge(findByName("남부터미널역"), findByName("양재역"), 5));
        addTimeEdge(new TimeEdge(findByName("양재역"), findByName("매봉역"), 1));
        addTimeEdge(new TimeEdge(findByName("강남역"), findByName("양재역"), 8));
        addTimeEdge(new TimeEdge(findByName("양재역"), findByName("양재시민의숲역"), 3));
    }
}
