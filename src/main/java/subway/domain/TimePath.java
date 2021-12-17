package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class TimePath implements Comparable<TimePath> {

    private List<Station> path = new ArrayList<>();
    private final int totalDistance;
    private final int totalTime;

    public TimePath(Station nextStation, int distance, int time) {
        this.path.add(nextStation);
        this.totalDistance = distance;
        this.totalTime = time;
    }

    public TimePath(List<Station> path, int distance, int time) {
        this.path = path;
        this.totalDistance = distance;
        this.totalTime = time;
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

    public int getTotalTime() {
        return this.totalTime;
    }

    @Override
    public int compareTo(TimePath o) {
        return Integer.compare(this.getTotalTime(), o.getTotalTime());
    }
}