import java.util.Scanner;

public class TestSimCard {
    public static void main(String[] args) {
        Phone myPhone = new Phone(randomSimCard());
        myPhone.infoSim();

        SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
        for (int i = 0; i < simCards.length; i++) {
            simCards[i] = randomOperator();
        }

        for (int i = 0; i < simCards.length; i += 2) {
            myPhone.makeCall(simCards[i].getNumber());
            System.out.print("Ваш баланс: ");
            myPhone.printBalance();
            System.out.println();
        }

        for (int i = 1; i < simCards.length; i += 2) {
            myPhone.receiveCall(simCards[i].getNumber());
            System.out.print("Ваш баланс: ");
            myPhone.printBalance();
            System.out.println();
        }
    }

    private static SimCard randomSimCard() {
        int random = (int) (Math.random() * 3 + 1);
        String number = "";
        int numberLength = 7;
        for (int i = 0; i < numberLength; i++) {
            number += (int) (Math.random() * 9 + 1);
        }
        if (random == 1) {
            return new MtsSimCard((int) (Math.random() * 20 + 5), number);
        } else if (random == 2) {
            return new A1SimCard((int) (Math.random() * 20 + 5), number);
        } else {
            return new LifeSimCard((int) (Math.random() * 20 + 5), number);
        }
    }

    private static SimCard randomOperator() {
        int random = (int) (Math.random() * 3 + 1);
        System.out.print("Введите номер: ");
        Scanner scanner = new Scanner(System.in);
        if (random == 1) {
            return new MtsSimCard((int) (Math.random() * 20 + 5), scanner.nextLine());
        } else if (random == 2) {
            return new A1SimCard((int) (Math.random() * 20 + 5), scanner.nextLine());
        } else {
            return new LifeSimCard((int) (Math.random() * 20 + 5), scanner.nextLine());
        }
    }
}
