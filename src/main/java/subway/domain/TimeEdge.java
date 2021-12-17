package subway.domain;

public class TimeEdge implements Comparable<TimeEdge> {

    private Station startStation;
    private Station endStation;
    private int time;


    public TimeEdge(Station startStation, Station endStation, int time) {
        this.startStation = startStation;
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