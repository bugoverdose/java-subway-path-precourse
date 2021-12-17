package subway.domain;

public class TimeEdge implements Comparable<TimeEdge> {

    private Station endStation;
    private int time;


    public TimeEdge(Station endStation, int time) {
        this.endStation = endStation;
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(TimeEdge o) {
        return Integer.compare(this.getTime(), o.getTime());
    }
}