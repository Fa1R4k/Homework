package lesson11.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Messenger {

    private static ArrayList<User> userList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        chooseActionMainMenu();
    }

    private static void printMainMenu() {
        System.out.println("""
                        "1" -> Register a new user
                Main    "2" -> Log in to your saved user
                Menu:   "3" -> Delete saved user
                        "0" -> Exit
                        
                """);
    }

    private static void chooseActionMainMenu() {
        printMainMenu();
        System.out.print("Choose your action: ");
        int action = chooseAction();
        switch (action) {
            case 1 -> registerNewUser();
            case 2 -> logInUser();
            case 3 -> choseDeleteUser();
            case 0 -> exit();
            default -> System.out.println("The input must contain only numbers[1,2,3]");
        }
        chooseActionMainMenu();
    }

    private static void choseDeleteUser() {
        if (!userList.isEmpty()) {
            System.out.println("Select the user to delete");
            User deleteUser = selectUser();
            deleteUser(deleteUser);
        } else {
            System.out.println("You don't have saved user!");
        }
    }

    private static int chooseAction() {
        String action = scanner.nextLine();
        while (!action.matches("\\d")) {
            System.out.print("The input must contain only numbers.\nTry again: ");
            action = scanner.nextLine();
        }
        return Integer.parseInt(action);
    }

    private static void registerNewUser() {
        System.out.print("Enter the name of new user: ");
        if (userList.add(new User(scanner.nextLine()))) {
            System.out.println("Registration was successful!\n");
        } else {
            System.out.println("Something went wrong");
            exit();
        }
    }

    private static void printUserList() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + userList.get(i).getName());
        }
    }

    private static void logInUser() {
        if (!userList.isEmpty()) {
            User loginUser = selectUser();
            chooseActionUserMenu(loginUser);
        } else {
            System.out.println("You don't have saved user!");
        }
    }

    private static User selectUser() {
        printUserList();
        System.out.print("Select user: ");
        int selectUser = chooseAction() - 1;
        while (selectUser > userList.size() - 1 || selectUser < 0) {
            System.out.println("The input must contain only numbers[1-" + userList.size() + "]\n Try again:");
            selectUser = chooseAction() - 1;
        }
        return userList.get(selectUser);
    }

    private static void printUserMenu(User user) {
        System.out.printf("""
                   UserName: %s
                        "1" -> Send Message
                User    "2" -> Check messages%s
                Menu:   "3" -> Delete this user
                        "0" -> Back to Menu
                            
                """, user.getName(), getMessageCount(user));
    }

    private static String getMessageCount(User user) {
        int countMessage = user.getCountMassages();
        return countMessage > 0 ? " (" + countMessage + " new messages)" : "";
    }

    private static void chooseActionUserMenu(User user) {
        printUserMenu(user);
        System.out.print("Choose your action: ");
        int action = chooseAction();
        switch (action) {
            case 1 -> sendMessage(user);
            case 2 -> checkMessage(user);
            case 3 -> confirmDeleteUser(user);
            case 0 -> chooseActionMainMenu();
            default -> System.out.println("The input must contain only numbers[0,1,2,3]");
        }
        chooseActionUserMenu(user);
    }

    private static void deleteUser(User deleteUser) {
        userList.remove(deleteUser);
        System.out.println("User(" + deleteUser.getName() + ") has been successfully deleted");
    }

    private static void confirmDeleteUser(User user) {
        System.out.println("Are you sure you want to delete User(" + user.getName() + ")");
        System.out.println("""
                "1" -> Yes.
                "Any number" -> No.
                """);
        System.out.print("The choice is yours: ");
        int action = chooseAction();
        if (action == 1) {
            deleteUser(user);
            chooseActionMainMenu();
        } else {
            System.out.println("Good choice!");
        }
    }

    private static void sendMessage(User user) {
        User fromUser = selectUser();
        System.out.print("Enter your message: ");
        user.sendMessage(fromUser, scanner.nextLine());
    }

    private static void checkMessage(User user) {
        user.checkMessage();
    }

    private static void exit() {
        System.out.println("GoodBye");
        System.exit(1);
    }
}
