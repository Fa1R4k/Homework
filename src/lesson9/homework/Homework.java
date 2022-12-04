package lesson9.homework;

import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        registration();
    }

    private static boolean registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль ");
        String password = scanner.nextLine();

        System.out.print("Повторно введите пароль: ");
        String verificationPassword = scanner.nextLine();

        try {
            checkLogic(login, password, verificationPassword);
            System.out.println("Вы успешно зарегистрированы!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("Повторите попытку!\n");
            registration();
        }
        return true;
    }

    private static void checkLogic(String login, String password, String verificationPassword) throws WrongLoginException, WrongPasswordException {
        if (checkLogin(login)) {
            throw new WrongLoginException("Неверные символы для логина." +
                    "(Используйте буквы латинского алфавита, цифры или символ \"_\")");
        } else if (checkLengthLogin(login)) {
            throw new WrongLoginException("Неверная длинна логина.(Максимум 20 символов)");
        }

        if (checkPassword(password, verificationPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    private static boolean checkLogin(String login) {
        final String LOGIN_REGEX = "[A-z\\d_]*";
        return LOGIN_REGEX.equals(login);
    }

    private static boolean checkLengthLogin(String login) {
        final int MAX_LOGIN_LENGTH = 20;
        final int MIN_LOGIN_LENGTH = 1;
        return !(MAX_LOGIN_LENGTH >= login.length() && login.length() >= MIN_LOGIN_LENGTH);
    }

    private static boolean checkPassword(String password, String verificationPassword) {
        return !password.equals(verificationPassword);
    }
}