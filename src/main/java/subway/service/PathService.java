package subway.service;

import static subway.view.InputView.*;

public class PathService {

    public void run() {
        printPathViewMenu();
        while (true) {
            String userChoice = requestUserChoiceInput();
            if (userChoice.equals("1")) {
                break;
            }
            if (userChoice.equals("2")) {
                break;
            }
            if (userChoice.equals("B")) {
                break;
            }
        }
    }
}
