package lesson9.homework;

import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        handlerException();
    }

    private static void handlerException() {
        boolean finalCheck = false;
        try {
            System.out.println(registration());
            finalCheck = true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("Повторите попытку!\n");
            handlerException();
        } finally {
            if (finalCheck) {
                System.out.println("Программа завершенна");
            }
        }
    }

    private static boolean registration() throws WrongLoginException, WrongPasswordException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль ");
        String password = scanner.nextLine();

        System.out.print("Повторно введите пароль: ");
        String verificationPassword = scanner.nextLine();

        if (!login.matches("[A-z\\d_]*")) {
            throw new WrongLoginException("Неверные символы для логина." +
                    "(Используйте буквы латинского алфавита, цифры или символ \"_\")");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Неверная длинна логина.(Максимум 20 символов)");
        }

        if (!verificationPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }
}
