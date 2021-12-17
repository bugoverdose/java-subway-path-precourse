package subway.utils;

import subway.domain.StationRepository;

import static subway.constants.ExceptionMessages.*;

public class InputValidator {

    public static void validateFindPathInput(String startStationName, String endStationName) {
        validateExistingStation(startStationName);
        validateExistingStation(endStationName);
        validateNotSameStation(startStationName, endStationName);
    }

    public static void validateNotSameStation (String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)){
            throw new IllegalArgumentException(SAME_STATION_NAME_INPUT_EXCEPTION);
        }
    }

    public static void validateExistingStation (String stationName) {
        if (StationRepository.findByName(stationName) == null){
            throw new IllegalArgumentException(NOT_EXISTING_STATION_NAME_EXCEPTION);
        }
    }
}
