package lesson11.homework;

public enum MainMenuEnum {
    REGISTER_USER_ACTION,
    LOG_IN_USER_ACTION,
    DELETE_USER_ACTION,
    EXIT_ACTION,
    DEFAULT_ACTION;

    public static MainMenuEnum getActionMainMenu(int actionNum) {
        return switch (actionNum) {
            case 1 -> REGISTER_USER_ACTION;
            case 2 -> LOG_IN_USER_ACTION;
            case 3 -> DELETE_USER_ACTION;
            case 0 -> EXIT_ACTION;
            default -> DEFAULT_ACTION;
        };
    }
}
