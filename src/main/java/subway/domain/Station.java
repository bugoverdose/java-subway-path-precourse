package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;
    private final List<DistancePath> nextDistanceEdges = new ArrayList<>();
    private final List<TimePath> nextTimeEdges = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<DistancePath> getDistanceEdges() {
        return nextDistanceEdges;
    }

    public List<TimePath> getTimeEdges() {
        return nextTimeEdges;
    }

    public void addDistanceEdge(DistancePath distancePath) {
        nextDistanceEdges.add(distancePath);
    }

    public void addTimeEdge(TimePath timePath) {
        nextTimeEdges.add(timePath);
    }
}
