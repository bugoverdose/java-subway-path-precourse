package subway.view;

import java.util.Scanner;

import static subway.constants.InputMessages.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void closeScanner() {
        scanner.close();
    }

    public static String requestUserChoiceInput() {
        System.out.println(REQUEST_USER_CHOICE_INPUT);
        return scanner.next();
    }

    public static void printMainMenu() {
        System.out.println(REQUEST_MAIN_MENU_SCREEN);
    }

    public static void printPathViewMenu() {
        System.out.println(REQUEST_PATH_VIEW_MENU_SCREEN);
    }

    public static String requestStartStationInput() {
        System.out.println(REQUEST_START_STATION_INPUT);
        return scanner.next();
    }

    public static String requestEndStationInput() {
        System.out.println(REQUEST_END_STATION_INPUT);
        return scanner.next();
    }
}
