package other;

public class TestSimCard {
    public static void main(String[] args) {
        Phone myPhone = new Phone(randomSimCard());

        System.out.println("Номера ваших сим карт: ");
        SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
        for (int i = 0; i < simCards.length; i++) {
            System.out.print("(" + (i + 1) + ") ");
            simCards[i] = randomSimCard();
        }
        System.out.println();
        Menu.printMenu();
        Menu.menu(myPhone, simCards);
    }

    private static SimCard randomSimCard() {
        int random = (int) (Math.random() * 3 + 1);
        String number = "";
        String pin = "";
        int numberLength = 7;
        int pinLength = 4;
        for (int i = 0; i < numberLength; i++) {
            number += (int) (Math.random() * 9 + 1);
            if (i < pinLength) {
                pin += (int) (Math.random() * 9 + 1);
            }
        }

        if (random == 1) {
            return new MtsSimCard((int) (Math.random() * 15), number, pin);
        } else if (random == 2) {
            return new A1SimCard((int) (Math.random() * 15), number, pin);
        } else {
            return new LifeSimCard((int) (Math.random() * 15), number, pin);
        }
    }
}
