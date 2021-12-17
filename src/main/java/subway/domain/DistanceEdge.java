package subway.domain;

public class DistanceEdge implements Comparable<DistanceEdge> {

    private Station nextStation;
    private int distance;

    public DistanceEdge(Station nextStation, int distance) {
        this.nextStation = nextStation;
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