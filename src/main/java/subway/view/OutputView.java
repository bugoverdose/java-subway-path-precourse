package subway.view;

import subway.domain.Station;

import java.util.List;

import static subway.constants.OutputMessages.*;

public class OutputView {

    public static void showPathInfo(int distance, int time, List<Station> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_RESULT_FORMAT);
        sb.append(LINES);
        sb.append(PATH_DISTANCE(distance));
        sb.append(PATH_TIME(time));
        sb.append(LINES);
        for (Station station : path) {
            sb.append(PATH_STATION(station));
        }
        System.out.println(sb);
    }
}
