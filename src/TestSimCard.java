import java.util.Scanner;

public class TestSimCard {
    public static void main(String[] args) {
        Phone myPhone = new Phone(randomSimCard());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Номера ваших сим кард: ");
        SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
        for (int i = 0; i < simCards.length; i++) {
            simCards[i] = randomSimCard();
            String massage = i == simCards.length - 1
                    ? simCards[i].getNumber() + ".\n"
                    : simCards[i].getNumber() + ", ";
            System.out.print(massage);
        }
        for (int i = 0; i < simCards.length; i++) {
            if (i % 2 == 0) {
                myPhone.insertNewSim(simCards[i]);
                System.out.print("Номер для звонка: ");
                myPhone.makeCall(scanner.nextLine());
                System.out.print("Ваш баланс: ");
                myPhone.printBalance();
                System.out.println();
            } else {
                myPhone.insertNewSim(simCards[i]);
                System.out.print("Номера с которого вам звонят: ");
                myPhone.receiveCall(scanner.nextLine());
                System.out.print("Ваш баланс: ");
                myPhone.printBalance();
                System.out.println();
            }
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
            return new MtsSimCard((int) (Math.random() * 15), number);
        } else if (random == 2) {
            return new A1SimCard((int) (Math.random() * 15), number);
        } else {
            return new LifeSimCard((int) (Math.random() * 15), number);
        }
    }
}
