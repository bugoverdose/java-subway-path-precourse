package subway.constants;

public class ExceptionMessages {

    public static String ERROR = "[ERROR] ";
    public static String INVALID_CHOICE_EXCEPTION = ERROR + "선택할 수 없는 기능입니다.\n";
    public static String NOT_EXISTING_STATION_NAME_EXCEPTION = ERROR + "존재하지 않는 역 이름입니다.\n";
    public static String SAME_STATION_NAME_INPUT_EXCEPTION = ERROR + "출발역과 도착역이 동일합니다.\n";
    public static String NOT_CONNECTED_EXCEPTION = ERROR + "두 역 사이를 오갈 수 없습니다.\n";
}
