package subway.controller;

import static subway.view.InputView.*;
import static subway.constants.InputMessages.*;

public class SubwayController {

    public void run() {
        printMainMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("Q")) {
                break;
            }
        }
    }
}
