package subway.controller;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.service.PathService;
import subway.utils.RouteGraph;

import static subway.utils.InputValidator.validateMainMenuInput;
import static subway.view.InputView.*;

public class SubwayController {

    private final PathService pathService = new PathService();

    public SubwayController() {
        initDatabase();
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            printMainMenu();
            isRunning = selectMainMenuAction();
        }

        closeScanner();
    }

    private boolean selectMainMenuAction() {
        while (true) {
            try {
                String userChoice = requestUserChoiceInput();
                validateMainMenuInput(userChoice);
                return runMainMenuAction(userChoice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean runMainMenuAction(String userChoice) {
        if (userChoice.equals("Q")) {
            return false;
        }
        if (userChoice.equals("1")) {
            pathService.run();
        }
        return true;
    }

    private void initDatabase() {
        StationRepository.initDatabase();
        LineRepository.initDatabase();
        SectionRepository.initDatabase();
        RouteGraph.initRouteGraphs();
    }
}
