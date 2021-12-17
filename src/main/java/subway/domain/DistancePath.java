package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class DistancePath implements Comparable<DistancePath> {

    private List<Station> path = new ArrayList<>();
    private int totalDistance;

    public DistancePath(Station nextStation, int distance) {
        this.path.add(nextStation);
        this.totalDistance = distance;
    }

    public DistancePath(List<Station> path, int totalDistance) {
        this.path = path;
        this.totalDistance = totalDistance;
    }

    public List<Station> getPath() {
        return this.path;
    }

    public Station getNextStation() {
        return this.path.get(path.size()-1);
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    @Override
    public int compareTo(DistancePath o) {
        return Integer.compare(this.getTotalDistance(), o.getTotalDistance());
    }
}