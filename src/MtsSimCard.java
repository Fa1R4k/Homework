public final class MtsSimCard extends SimCard {

    public MtsSimCard(double balance, String number) {
        super(balance, "29" + number);
    }

    @Override
    public String getOperatorName() {
        return "Mts";
    }

    @Override
    public void makeCall(String number) {
        int price = checkMobileOperator(number) ? 1 : 3;
        if (getBalance() >= price) {
            setBalance(getBalance() - price);
            System.out.println("Звоню на номер: " + number);
        } else {
            System.out.println("Звонок по  номеру " + number + " запрещен.");
        }
    }

    @Override
    public void receiveCall(String number) {
        int price = checkMobileOperator(number) ? 0 : 1;
        setBalance(getBalance() - price);
        System.out.println("Принимаю звонок с номера: " + number);
    }

    private static boolean checkMobileOperator(String number) {
        return number.startsWith("29");
    }
}