package lesson15.homework;

public class BigElevator implements Runnable {
    private final int ELEVATOR_SIZE = 10;
    private final int ELEVATOR_TIME = 3000;
    private int allCountTransportedPeople = 0;
    private int countTransportedPeople = 0;
    private ElevatorQueue elevatorQueue;

    public BigElevator(ElevatorQueue elevatorQueue) {
        this.elevatorQueue = elevatorQueue;
    }

    public void run() {
        while (elevatorQueue.getPeopleCount() > 0) {
            synchronized (elevatorQueue) {
                int countPeople = Math.min(elevatorQueue.getPeopleCount(), ELEVATOR_SIZE);
                System.out.println("Большой лифт поднял " + countPeople + " человек");
                elevatorQueue.lifting(countPeople);
                countTransportedPeople += countPeople;
            }
            try {
                Thread.sleep(ELEVATOR_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("    Большой лифт поднял всего " +
                (elevatorQueue.isStop() ? allCountTransportedPeople : countTransportedPeople)
                + " человек");
        allCountTransportedPeople += countTransportedPeople;
        countTransportedPeople = 0;
    }
}

