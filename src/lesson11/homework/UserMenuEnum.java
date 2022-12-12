package lesson11.homework;

public enum UserMenuEnum {
    SEND_MESSAGE_ACTION,
    CHECK_MESSAGES_ACTION,
    DELETE_THIS_USER_ACTION,
    BACK_TO_MENU_ACTION,
    DEFAULT_ACTION;

    public static UserMenuEnum getActionUserMenu(int actionNum) {
        return switch (actionNum) {
            case 1 -> SEND_MESSAGE_ACTION;
            case 2 -> CHECK_MESSAGES_ACTION;
            case 3 -> DELETE_THIS_USER_ACTION;
            case 0 -> BACK_TO_MENU_ACTION;
            default -> DEFAULT_ACTION;
        };
    }
}
