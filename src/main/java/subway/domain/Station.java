package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;
    private final List<DistanceEdge> distanceEdges = new ArrayList<>();
    private final List<TimeEdge> timeEdges = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<DistanceEdge> getDistanceEdges() {
        return distanceEdges;
    }

    public List<TimeEdge> getTimeEdges() {
        return timeEdges;
    }

    public void addDistanceEdge(DistanceEdge distanceEdge) {
        distanceEdges.add(distanceEdge);
    }

    public void addTimeEdge(TimeEdge timeEdge) {
        timeEdges.add(timeEdge);
    }
}
