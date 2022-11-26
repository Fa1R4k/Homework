import java.util.Scanner;

public class SimCard {
    private double balance;
    private String number;
    private String pin;
    private boolean block = false;

    protected SimCard(double balance, String number, String pin) {
        this.balance = balance;
        this.number = number;
        this.pin = pin;
    }

    public void checkPin() {
        Scanner scanner = new Scanner(System.in);
        int tryCount = 3;
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите пин-код(" + (tryCount - i) + "): ");
            if (pin.equals(scanner.nextLine())) {
                System.out.println("Пин-код верный. Добро пожаловать в сеть " + getOperatorName());
                return;
            }
        }
        System.out.println("Ваша сим-карта заблокированна. Для дальнейшей инструкции обратитесь к оператору " + getOperatorName());
        setBlock(true);
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public boolean isBlock() {
        return block;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getOperatorName() {
        return "operatorName";
    }

    public void makeCall(String number) {
        System.out.println("Звоню на номер: " + number);
    }

    public void receiveCall(String number) {
        System.out.println("Принимаю звонок с номера:" + number);
    }
}
