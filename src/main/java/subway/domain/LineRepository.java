package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    private static void addLine(Line line) {
        lines.add(line);
    }

    public static void initDatabase() {
        List<String> initialLine = Stream.of("2호선", "3호선", "신분당선")
                .collect(Collectors.toList());
        for (String lineName : initialLine) {
            addLine(new Line(lineName));
        }
    }
}
