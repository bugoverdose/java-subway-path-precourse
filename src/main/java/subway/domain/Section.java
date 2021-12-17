package subway.domain;

public class Section {

    private final Line line;
    private final Station curStation;
    private final Station nextStation;
    private final int distance;
    private final int time;

    public Section(String lineName, String curStationName, String nextStationName, int distance, int time) {
        this.line = LineRepository.findByName(lineName);
        this.curStation = StationRepository.findByName(curStationName);
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
