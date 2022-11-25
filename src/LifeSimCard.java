public final class LifeSimCard extends SimCard {

    public LifeSimCard(double balance, String number) {
        super(balance, "44" + number);
    }

    @Override
    public String getOperatorName() {
        return "Life";
    }

    public void makeCall(String number) {
        int price = 3;
        if (checkMobileOperator(number)) {
            price = 1;
        }
        if (getBalance() >= price) {
            setBalance(getBalance() - price);
            System.out.println("Звоню на номер: " + number);
        } else {
            System.out.println("Звонок запрещен.");
        }
    }

    public void receiveCall(String number) {
        int price = 1;
        if (checkMobileOperator(number)) {
            price = 0;
        }
        if (getBalance() >= price) {
            setBalance(getBalance() - price);
            System.out.println("Принимаю звонок с номера: " + number);
        } else {
            System.out.println("Вам звонит номер: " + number + " Звонок запрещен(У вас недостаточно средств).");
        }
    }

    private static boolean checkMobileOperator(String number) {
        return number.startsWith("44");
    }
}