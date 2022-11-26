public class BlockedSimCard extends SimCard {

    public BlockedSimCard(double balance, String number, String pin) {
        super(balance, number, pin);
    }


    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public String getNumber() {
        return super.getNumber();
    }

    @Override
    public String getOperatorName() {
        return "BlockedCard";
    }

    @Override
    public void makeCall(String number) {
        System.out.println("Ваша сим карта заблокированна.");
    }

    @Override
    public void receiveCall(String number) {
        System.out.println("Ваша сим карта заблокированна.");
    }

    @Override
    public void setBalance(double balance) {
        System.out.println("Ваша сим карта заблокированна.");
    }

    @Override
    public boolean isBlock() {
        return true;
    }
}
