package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimePath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static subway.view.InputView.*;
import static subway.view.OutputView.showPathInfo;

public class PathService {

    public void run() {
        printPathViewMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("1")) {
                break;
            }
            if (userChoice.equals("2")) {
                findPathByMinTime();
            }
            if (userChoice.equals("B")) {
                break;
            }
        }
    }

    private void findPathByMinTime() {
        Station startStation = StationRepository.findByName(requestStartStationInput());
        Station endStation = StationRepository.findByName(requestEndStationInput());

        PriorityQueue<TimePath> queue = new PriorityQueue<>();
        queue.addAll(startStation.getTimeEdges());

        while (!queue.isEmpty()) {
            TimePath cur = queue.poll();
            Station nextStation = cur.getNextStation();
            if (nextStation == endStation) {
                showPathInfo(0, cur.getTotalTime(), cur.getPath());
                return;
            }

            for (TimePath edge : nextStation.getTimeEdges()) {
                List<Station> newPath = new ArrayList<>(cur.getPath());
                newPath.add(edge.getNextStation());
                int newTotalTime = edge.getTotalTime() + cur.getTotalTime();
                queue.add(new TimePath(newPath, newTotalTime));
            }
        }
        throw new IllegalArgumentException("");
    }
}
