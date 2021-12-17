package subway.domain;

public class DistanceEdge implements Comparable<DistanceEdge> {

    private Station startStation;
    private Station endStation;
    private int distance;


    public DistanceEdge(Station startStation, Station endStation, int distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(DistanceEdge o) {
        return Integer.compare(this.getDistance(), o.getDistance());
    }
}