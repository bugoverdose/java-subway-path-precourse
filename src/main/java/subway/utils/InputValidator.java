package subway.utils;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static subway.constants.ExceptionMessages.*;
import static subway.constants.ExceptionMessages.INVALID_CHOICE_EXCEPTION;

public class InputValidator {

    public static void validateMainMenuInput(String input) {
        List<String> validateInputs = Stream.of("1", "Q")
                .collect(Collectors.toList());
        if (!validateInputs.contains(input)) {
            throw new IllegalArgumentException(INVALID_CHOICE_EXCEPTION);
        }
    }

    public static void validatePathMenuInput(String input) {
        List<String> validateInputs = Stream.of("1", "2", "B")
                .collect(Collectors.toList());
        if (!validateInputs.contains(input)) {
            throw new IllegalArgumentException(INVALID_CHOICE_EXCEPTION);
        }
    }

    public static void validateFindPathInput(String startStationName, String endStationName) {
        validateExistingStation(startStationName);
        validateExistingStation(endStationName);
        validateNotSameStation(startStationName, endStationName);
    }

    private static void validateNotSameStation (String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)){
            throw new IllegalArgumentException(SAME_STATION_NAME_INPUT_EXCEPTION);
        }
    }

    private static void validateExistingStation (String stationName) {
        if (StationRepository.findByName(stationName) == null){
            throw new IllegalArgumentException(NOT_EXISTING_STATION_NAME_EXCEPTION);
        }
    }

    public static void validatePathConnection(List<Station> path) {
        if (path == null || path.isEmpty()){
            throw new IllegalArgumentException(NOT_CONNECTED_EXCEPTION);
        }
    }
}
