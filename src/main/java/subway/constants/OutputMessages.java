package subway.constants;

import subway.domain.Station;

public class OutputMessages {

    private static final String INFO = "[INFO] ";
    public static String BLANK_LINE = "\n";
    public static String LINES = INFO + "---" + BLANK_LINE;

    public static String PATH_RESULT_FORMAT = "## 조회 결과" + BLANK_LINE;

    public static String PATH_DISTANCE(int distance) {
        return INFO + "총 거리: " + distance + "km" + BLANK_LINE;
    }

    public static String PATH_TIME(int time) {
        return INFO + "총 소요 시간: " + time + "분" + BLANK_LINE;
    }

    public static String PATH_STATION(Station station) {
        return INFO + station.getName() + BLANK_LINE;
    }
}
