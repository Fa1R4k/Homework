import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your number: ");
        if (scanner.nextInt() % 2 == 0) {
            System.out.println("Число четное!");
        } else {
            System.out.println("Число нечетное");
        }
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First number: ");
        int timeFirstNum = scanner.nextInt();
        int firstNum = timeFirstNum > 0 ? timeFirstNum : -timeFirstNum;

        System.out.print("Second number: ");
        int timeSecondNum = scanner.nextInt();
        int secondNum = timeSecondNum > 0 ? timeSecondNum : -timeSecondNum;

        System.out.print("Third number: ");
        int timeThirdNum = scanner.nextInt();
        int thirdNum = timeThirdNum > 0 ? timeThirdNum : -timeThirdNum;

        if (firstNum < secondNum && firstNum < thirdNum) {
            System.out.println(firstNum + " is smallest number");
        } else if (secondNum < thirdNum) {
            System.out.println(secondNum + " is smallest number");
        } else {
            System.out.println(thirdNum + " is smallest number");
        }
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your number: ");

        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Понедельник");

            case 2 -> System.out.println("Вторник");

            case 3 -> System.out.println("Среда");

            case 4 -> System.out.println("Четверг");

            case 5 -> System.out.println("Пятница");

            case 6 -> System.out.println("Суббота");

            case 7 -> System.out.println("Воскресенье");

            default -> System.out.println("Неизвестный день недели");
        }
    }
}
