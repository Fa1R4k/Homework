import java.util.Scanner;

public class HomeworkCreditCard {
    public static void main(String[] args) {
        CreditCard firstCard = new CreditCard("BY1231ALFA", Math.random() * 100 + 1);
        CreditCard secondCard = new CreditCard("BY1231BEL", Math.random() * 100 + 1);
        CreditCard thirdCard = new CreditCard("BY1322BNB", Math.random() * 100 + 1);

        firstCard.information();
        secondCard.information();
        thirdCard.information();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: ");
        firstCard.addMoney(scanner.nextDouble());

        System.out.print("Enter the deposit amount: ");
        secondCard.addMoney(scanner.nextDouble());

        System.out.print("Enter the withdraw amount: ");
        thirdCard.withdrawMoney(scanner.nextDouble());
        System.out.println();

        firstCard.information();
        secondCard.information();
        thirdCard.information();
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
        accountMoney += count;
    }

    public void withdrawMoney(double count) {
        accountMoney -= count;
    }

    public void information() {
        System.out.println("AccountNumber: " + accountNumber);
        System.out.println("AccountMoney: " + String.format("%.2f", accountMoney) + "$\n");

    }
}
