package other;

public class Phone {

    private SimCard sim;
    private boolean phoneStatus = false;

    public Phone(SimCard sim) {
        this.sim = sim;
    }

    public SimCard getSim() {
        return sim;
    }

    public void setSim(SimCard sim) {
        this.sim = sim;
    }

    public boolean isPhoneStatus() {
        return phoneStatus;
    }

    public void turnOnPhone() {
        if (!sim.isBlock()) {
            sim.checkPin();
        } else {
            System.out.println("Эта сим-карта заблокированна.");
        }
        phoneStatus = true;
    }

    public void turnOffPhone() {
        phoneStatus = false;

    }

    public void insertNewSim(SimCard sim) {
        if (!sim.isBlock()) {
            if (isPhoneStatus()) {
                sim.checkPin();
            } else {
                System.out.println("Сим карта заменена. Пин код будет запрошен при включении.\n");
            }
        }
        this.sim = sim;
        System.out.println("Номер новой сим карты: " + sim.getNumber() +
                ". Имя оператора:  " + sim.getOperatorName() +
                ". Ваш баланс: " + sim.getBalance() + "bn.");
    }

    public void makeCall(String number) {
        if (phoneStatus) {
            sim.makeCall(number);
        }
    }

    public void receiveCall(String number) {
        if (phoneStatus) {
            sim.receiveCall(number);
        }
    }

    public void printBalance() {
        if (phoneStatus) {
            System.out.printf("Ваш баланс: " + String.format("%.2f", sim.getBalance()) + "\n");
        }
    }
}
