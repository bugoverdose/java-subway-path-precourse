package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    private static void addSection(String lineName, String stationName1, String stationName2, int distance, int time) {
        sections.add(new Section(lineName, stationName1, stationName2, distance, time));
        sections.add(new Section(lineName, stationName2, stationName1, distance, time));
    }

    public static Section findBySectionByStations(Station startStation, Station nextStation) {
        for (Section section : sections) {
            if (!section.getCurStation().equals(startStation)) continue;
            if (!section.getNextStation().equals(nextStation)) continue;
            return section;
        }
        throw new IllegalArgumentException();
    }

    public static List<Section> findSectionsByLine(Line line) {
        List<Section> sectionList = new ArrayList<>();

        for (Section section : sections) {
            if (!section.getLine().equals(line)) continue;
            sectionList.add(section);
        }
        return sectionList;
    }

    public static void initDatabase() {
        addSection("2호선", "교대역", "강남역", 2, 3);
        addSection("2호선", "강남역", "역삼역", 2, 3);

        addSection("3호선", "교대역", "남부터미널역", 3, 2);
        addSection("3호선", "남부터미널역", "양재역", 6, 5);
        addSection("3호선", "양재역", "매봉역", 1, 5);

        addSection("신분당선", "강남역", "양재역", 2, 8);
        addSection("신분당선", "양재역", "양재시민의숲역", 10, 3);
    }
}
