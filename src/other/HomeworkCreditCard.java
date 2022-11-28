package other;

import java.util.Scanner;

public class HomeworkCreditCard {
    public static void main(String[] args) {
        CreditCard firstCard = new CreditCard("BY1231ALFA", Math.random() * 100 + 1);
        CreditCard secondCard = new CreditCard("BY1231BEL", Math.random() * 100 + 1);
        CreditCard thirdCard = new CreditCard("BY1322BNB", Math.random() * 100 + 1);

        firstCard.getInformation();
        secondCard.getInformation();
        thirdCard.getInformation();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: ");
        firstCard.addMoney(scanner.nextDouble());

        System.out.print("Enter the deposit amount: ");
        secondCard.addMoney(scanner.nextDouble());

        System.out.print("Enter the withdraw amount: ");
        thirdCard.withdrawMoney(scanner.nextDouble());
        System.out.println();

        firstCard.getInformation();
        secondCard.getInformation();
        thirdCard.getInformation();
    }
}

class CreditCard {
    private String accountNumber;
    private double accountMoney;

    public CreditCard(String accountNumber, double accountMoney) {
        this.accountNumber = accountNumber;
        this.accountMoney = accountMoney;
    }

    public void addMoney(double count) {
        System.out.println("Success!");
        accountMoney += count;
    }

    public void withdrawMoney(double count) {
        if (accountMoney > count && count != 0) {
            accountMoney -= count;
            System.out.println("Success!");
        } else {
            System.out.println("Not enough money!!!!!");
        }
    }

    public void getInformation() {
        System.out.println("AccountNumber: " + accountNumber);
        System.out.println("AccountMoney: " + String.format("%.2f", accountMoney) + "$\n");
    }
}
