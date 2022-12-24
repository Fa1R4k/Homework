package lesson15.homework;

public class ExpressElevator implements Runnable {
    private final int ELEVATOR_SIZE = 6;
    private final int ELEVATOR_TIME = 1000;
    private int countTransportedPeople = 0;
    private int allCountTransportedPeople = 0;
    private ElevatorQueue elevatorQueue;

    public ExpressElevator(ElevatorQueue elevatorQueue) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.elevatorQueue = elevatorQueue;
    }

    public void run() {
        while (elevatorQueue.getPeopleCount() > 0) {
            synchronized (elevatorQueue) {
                int countPeople = Math.min(elevatorQueue.getPeopleCount(), ELEVATOR_SIZE);
                System.out.println("Скоростной лифт поднял " + countPeople + " человек");
                elevatorQueue.lifting(countPeople);
                countTransportedPeople += countPeople;
            }
            try {
                Thread.sleep(ELEVATOR_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("    Скоростной лифт поднял всего " +
                (elevatorQueue.isStop() ? allCountTransportedPeople : countTransportedPeople)
                + " человек");
        allCountTransportedPeople += countTransportedPeople;
        countTransportedPeople = 0;
    }
}
