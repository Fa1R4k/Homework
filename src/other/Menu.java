package other;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.print("""
                1 -> Включить/Выключить телефон.
                2 -> Вставить сим-карту в телефон.
                3 -> Вывести информацию о доступных сим-картах.
                4 -> Совершить звонок.
                5 -> Принять звонок.
                6 -> Пополнить баланс.
                7 -> Информация о сим-карте в телефоне.
                0 -> Выход.
                """);
    }

    public static void menu(Phone phone, SimCard[] simCards) {
        System.out.println();
        System.out.print("Выберите ваше действие: ");
        String move = scanner.nextLine();
        System.out.println();
        logicMenu(move, phone, simCards);

    }

    private static void logicMenu(String move, Phone phone, SimCard[] simCards) {
        switch (move) {
            case "0" -> System.out.println("Goodbye ♡");
            case "1" -> {
                menuTurnPhone(phone);
                menu(phone, simCards);
            }
            case "2" -> {
                menuInsertSim(phone, simCards);
                menu(phone, simCards);
            }
            case "3" -> {
                simCardsInfo(simCards);
                menu(phone, simCards);
            }
            case "4" -> {
                menuMakeCall(phone);
                menu(phone, simCards);
            }
            case "5" -> {
                menuReceiveCall(phone);
                menu(phone, simCards);
            }
            case "6" -> {
                if (!phone.getSim().isBlock()) {
                    menuAddBalance(phone);
                } else {
                    System.out.println("Ваша сим карта заблокированна.");
                }
                menu(phone, simCards);
            }
            case "7" -> {
                phoneSimInfo(phone);
                menu(phone, simCards);
            }
            default -> {
                System.out.println("Что-то пошло не так. Повторите действие.");
                menu(phone, simCards);
            }
        }
    }

    private static void menuAddBalance(Phone phone) {
        if (phone.isPhoneStatus()) {
            String sum = "0";
            boolean work = true;
            phone.printBalance();
            while (work) {
                System.out.print("Введите сумму пополнения: ");
                sum = scanner.nextLine();
                if (sum.matches("\\d+\\.?\\d*")) {
                    work = false;
                } else {
                    System.out.println("Что-то пошло не так. Введите другую сумму пополнения:");
                }
            }
            phone.getSim().setBalance(phone.getSim().getBalance() + Double.parseDouble(sum));
            System.out.print("Средства зачисленны на баланс. ");
            phone.printBalance();
        } else {
            System.out.println("Телефон выключен.");
        }
    }

    private static void simCardsInfo(SimCard[] simCards) {
        for (int i = 0; i < simCards.length; i++) {
            System.out.println("(" + (i + 1) + ") " +
                    "Оператор: " + simCards[i].getOperatorName() +
                    " Баланс: " + simCards[i].getBalance() +
                    " Номер: " + simCards[i].getNumber());
        }
    }

    private static void menuTurnPhone(Phone phone) {
        boolean phoneIsOn = true;
        if (phone.isPhoneStatus() != phoneIsOn) {
            System.out.println("Телефон включен");
            phone.turnOnPhone();
            blockCard(phone);
        } else {
            System.out.println("Телефон выключен");
            phone.turnOffPhone();
        }
    }

    private static void menuReceiveCall(Phone phone) {
        if (phone.isPhoneStatus()) {
            String number = randomNumber();
            System.out.println("Вам звонит " + number);
            System.out.println("""
                    1 -> Ответить.
                    2 -> Отклонить.
                    """);
            System.out.print("Выберите действие: ");

            if ("1".equals(scanner.nextLine())) {
                phone.receiveCall(number);
                phone.printBalance();
            } else {
                System.out.println("Звонок отклонен");
            }
        } else {
            System.out.println("Ваш телефон выключен.");
        }
    }

    private static String randomNumber() {
        String mts = "29";
        String a1 = "33";
        String life = "44";
        String number = "";
        int randomOperator = (int) (Math.random() * 3 + 1);
        if (randomOperator == 1) {
            number += mts;
        } else if (randomOperator == 2) {
            number += a1;
        } else {
            number += life;
        }
        number += (int) (1000000 + Math.random() * 9000000);
        return number;
    }

    private static void menuMakeCall(Phone phone) {
        if (phone.isPhoneStatus()) {
            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();
            phone.makeCall(number);
            phone.printBalance();
        } else {
            System.out.println("Ваш телефон выключен.");
        }
    }

    private static void menuInsertSim(Phone phone, SimCard[] simCards) {
        simCardsInfo(simCards);
        System.out.print("Выберите сим-карту: ");
        SimCard tempSimCard = phone.getSim();
        String cardNum = scanner.nextLine();
        if (cardNum.matches("\\d0?")) {
            phone.insertNewSim(simCards[Integer.parseInt(cardNum) - 1]);
            blockCard(phone);
            simCards[(Integer.parseInt(cardNum) - 1)] = tempSimCard;
        } else {
            System.out.println("\"Что-то пошло не так.\"");
        }
    }

    private static void blockCard(Phone phone) {
        if (phone.getSim().isBlock()) {
            phone.setSim(new BlockedSimCard(phone.getSim().getBalance(), phone.getSim().getNumber(), "Block"));
        }
    }

    private static void phoneSimInfo(Phone phone) {
        if (phone.isPhoneStatus()) {
            System.out.print("Оператор: " + phone.getSim().getOperatorName() + ". ");
            System.out.print(" Номер: " + phone.getSim().getNumber() + " ");
            phone.printBalance();
        } else {
            System.out.println("Ваш телефон выключен.");
        }
    }
}
