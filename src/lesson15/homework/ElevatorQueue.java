package lesson15.homework;

public class ElevatorQueue {
    volatile private int peopleCount = 0;
    private boolean stop = false;
    public int getPeopleCount() {
        return peopleCount;
    }
    public boolean isStop() {
        return stop;
    }
    public void setStop() {
        this.stop = true;
    }

    public synchronized void lifting(int elevatorCapacity) {
        peopleCount -= elevatorCapacity;
    }
    public void addPeople(int count) {
        peopleCount += count;
    }
}
