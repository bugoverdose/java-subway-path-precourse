package subway.controller;

import subway.domain.DistanceEdgeRepository;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.TimeEdgeRepository;
import subway.service.PathService;

import static subway.view.InputView.*;

public class SubwayController {
    private final PathService pathService = new PathService();

    public void run() {
        initDatabase();
        printMainMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("1")) {
                pathService.run();
            }
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
