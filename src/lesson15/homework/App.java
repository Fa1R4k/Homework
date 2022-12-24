package lesson15.homework;

import java.util.Scanner;

public class App {
    private static ElevatorQueue elevatorQueue = new ElevatorQueue();

    public static void main(String[] args) {
        ExpressElevator expressElevator = new ExpressElevator(elevatorQueue);
        BigElevator bigElevator = new BigElevator(elevatorQueue);
        do {
            elevatorQueue.addPeople(getCountFromScanner());
            Thread express = new Thread(expressElevator);
            Thread big = new Thread(bigElevator);
            express.start();
            big.start();
            try {
                big.join();
                express.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!elevatorQueue.isStop());
    }

    private static int getCountFromScanner() {
        System.out.print("Введите количество людей: ");
        Scanner scanner = new Scanner(System.in);
        String countString;
        do {
            countString = scanner.nextLine();
        } while (!countString.matches("\\d+"));
        return checkStop(Integer.parseInt(countString));
    }

    private static int checkStop(int number) {
        if (number == 0) {
            System.out.println("\n      [Завершение программы...] \n");
            System.out.println("    За все время работы программы:");
            elevatorQueue.setStop();
        }
        return number;
    }
}
