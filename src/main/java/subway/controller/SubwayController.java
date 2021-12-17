package subway.controller;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.service.PathService;

import static subway.view.InputView.*;

public class SubwayController {
    private final PathService pathService = new PathService();

    public SubwayController() {
        initDatabase();
    }

    public void run() {
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
        SectionRepository.initDatabase();
    }
}
