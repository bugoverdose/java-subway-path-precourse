package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final String name;
    private final List<Section> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Section> getSections() { return sections; }

    public void addSection(String curStationName, String nextStationName, int distance, int time) {
        Section newSection = new Section(curStationName, this, nextStationName, distance, time);
        sections.add(newSection);
    }
}
