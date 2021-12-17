package subway.controller;

import subway.domain.DistanceEdgeRepository;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.TimeEdgeRepository;

import static subway.view.InputView.*;

public class SubwayController {

    public void run() {
        initDatabase();
        printMainMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("Q")) {
                break;
            }
        }
    }

    private void initDatabase() {
        StationRepository.initDatabase();
        LineRepository.initDatabase();
        DistanceEdgeRepository.initDatabase();
        TimeEdgeRepository.initDatabase();
    }
}
