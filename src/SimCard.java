public class SimCard {
    private double balance;
    private String number;

    protected SimCard(double balance, String number) {
        this.balance = balance;
        this.number = number;
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
