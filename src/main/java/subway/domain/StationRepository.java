package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    private static void addStation(Station station) {
        stations.add(station);
    }

    public static Station findByName(String name) {
        for (Station station : stations) {
            if (!station.getName().equals(name)) continue;
            return station;
        }
        throw new IllegalArgumentException();
    }

    public static void initDatabase() {
        List<String> initialStations = Stream.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .collect(Collectors.toList());
        for (String stationName : initialStations) {
            addStation(new Station(stationName));
        }
        registerDistanceEdges();
        registerTimeEdges();
    }

    private static void registerDistanceEdges() {
        findByName("교대역").addDistanceEdge(new DistanceEdge(findByName("강남역"), 2));
        findByName("강남역").addDistanceEdge(new DistanceEdge(findByName("역삼역"), 2));
        findByName("교대역").addDistanceEdge(new DistanceEdge(findByName("남부터미널역"), 3));
        findByName("남부터미널역").addDistanceEdge(new DistanceEdge(findByName("양재역"), 6));
        findByName("양재역").addDistanceEdge(new DistanceEdge(findByName("매봉역"), 1));
        findByName("강남역").addDistanceEdge(new DistanceEdge(findByName("양재역"), 2));
        findByName("양재역").addDistanceEdge(new DistanceEdge(findByName("양재시민의숲역"), 10));
    }

    private static void registerTimeEdges() {
        findByName("교대역").addTimeEdge(new TimeEdge(findByName("강남역"), 3));
        findByName("강남역").addTimeEdge(new TimeEdge(findByName("역삼역"), 3));
        findByName("교대역").addTimeEdge(new TimeEdge(findByName("남부터미널역"), 2));
        findByName("남부터미널역").addTimeEdge(new TimeEdge(findByName("양재역"), 5));
        findByName("양재역").addTimeEdge(new TimeEdge(findByName("매봉역"), 1));
        findByName("강남역").addTimeEdge(new TimeEdge(findByName("양재역"), 8));
        findByName("양재역").addTimeEdge(new TimeEdge(findByName("양재시민의숲역"), 3));
    }
}
