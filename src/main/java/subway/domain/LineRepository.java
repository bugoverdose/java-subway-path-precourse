package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public static Line findByName(String name) {
        for (Line line : lines) {
            if (!line.getName().equals(name)) continue;
            return line;
        }
        throw new IllegalArgumentException();
    }

    public static Section findBySectionByStations(Station startStation, Station nextStation) {
        for (Line line : lines) {
            for (Section section : line.getSections()) {
                if (!section.getCurStation().equals(startStation)) continue;
                if (!section.getNextStation().equals(nextStation)) continue;
                return section;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void initDatabase() {
        List<String> initialLine = Stream.of("2호선", "3호선", "신분당선")
                .collect(Collectors.toList());

        for (String lineName : initialLine) {
            addLine(new Line(lineName));
        }

        initSectionData();
    }

    public static void initSectionData() {
        Line line2 = findByName("2호선");
        line2.addSection("교대역", "강남역", 2, 3);
        line2.addSection("강남역", "역삼역", 2, 3);

        Line line3 = findByName("3호선");
        line3.addSection("교대역", "남부터미널역", 3, 2);
        line3.addSection("남부터미널역", "양재역", 6, 5);
        line3.addSection("양재역", "매봉역", 1, 5);

        Line lineNew = findByName("신분당선");
        lineNew.addSection("강남역", "양재역", 2, 8);
        lineNew.addSection("양재역", "양재시민의숲역", 10, 3);
    }
}
