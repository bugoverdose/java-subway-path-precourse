package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class TimePath implements Comparable<TimePath> {

    private List<Station> path = new ArrayList<>();
    private int totalTime;

    public TimePath(Station nextStation, int time) {
        this.path.add(nextStation);
        this.totalTime = time;
    }

    public TimePath(List<Station> path, int time) {
        this.path = path;
        this.totalTime = time;
    }

    public List<Station> getPath() {
        return this.path;
    }

    public Station getNextStation() {
        return this.path.get(path.size()-1);
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    @Override
    public int compareTo(TimePath o) {
        return Integer.compare(this.getTotalTime(), o.getTotalTime());
    }
}