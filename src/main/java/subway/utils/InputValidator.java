package subway.utils;

import subway.domain.StationRepository;

import static subway.constants.ExceptionMessages.NOT_EXISTING_STATION_NAME_EXCEPTION;

public class InputValidator {

    public static void validateFindPathInput(String startStationName, String endStationName) {
        validateExistingStation(startStationName);
        validateExistingStation(endStationName);
    }

    public static void validateExistingStation (String stationName) {
        if (StationRepository.findByName(stationName) == null){
            throw new IllegalArgumentException(NOT_EXISTING_STATION_NAME_EXCEPTION);
        }
    }
}
