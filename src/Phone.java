public class Phone {

    private SimCard sim;

    public Phone(SimCard sim) {
        this.sim = sim;
    }

    public void insertNewSim(SimCard sim) {
        this.sim = sim;
        System.out.println("Номер новой сим карты: " + sim.getNumber() +
                ". Имя оператора:  " + sim.getOperatorName() +
                ". Ваш баланс: " + sim.getBalance() + "bn.");
    }

    public void makeCall(String number) {
        sim.makeCall(number);
    }

    public void receiveCall(String number) {
        sim.receiveCall(number);
    }

    public void printBalance() {
        System.out.printf(String.format("%.2f", sim.getBalance()) + "\n");
    }
}
