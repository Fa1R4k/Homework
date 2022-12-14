package other;

public final class LifeSimCard extends SimCard {

    public LifeSimCard(double balance, String number, String pin) {
        super(balance, "44" + number, pin);
        System.out.println("Оператор сим-карты: " + getOperatorName() +
                ". Номер сим-карты: " + getNumber() +
                ". Баланс сим-карты: " + getBalance() +
                ". Пин код сим-карты: " + pin + ".");
    }

    @Override
    public String getOperatorName() {
        return "Life";
    }

    public void makeCall(String number) {
        int price = checkMobileOperator(number) ? 1 : 3;
        if (getBalance() >= price) {
            setBalance(getBalance() - price);
            System.out.println("Звоню на номер: " + number);
        } else {
            System.out.println("Звонок по  номеру " + number + " запрещен.");
        }
    }

    public void receiveCall(String number) {
        int price = checkMobileOperator(number) ? 0 : 1;
        setBalance(getBalance() - price);
        System.out.println("Принимаю звонок с номера: " + number);
    }

    private static boolean checkMobileOperator(String number) {
        return number.startsWith("44");
    }
}