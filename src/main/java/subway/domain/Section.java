package subway.domain;

public class Section {

    private final Station curStation;
    private final Line line;
    private final Station nextStation;
    private final int distance;
    private final int time;

    public Section(Station curStation, Line line, Station nextStation, int distance, int time) {
        this.curStation = curStation;
        this.line = line;
        this.nextStation = nextStation;
        this.distance = distance;
        this.time = time;
    }

    public Section(String curStationName, Line line, String nextStationName, int distance, int time) {
        this.curStation = StationRepository.findByName(curStationName);
        this.line = line;
        this.nextStation = StationRepository.findByName(nextStationName);
        this.distance = distance;
        this.time = time;
    }

    public Station getCurStation() {
        return curStation;
    }

    public Line getLine() {
        return line;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
