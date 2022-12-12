package lesson12.homework;

public class Horse extends Pet {
    private double speed;

    public Horse(String name, String breed, double speed) {
        super(name, breed);
        this.speed = speed;
    }

    public String toString() {
        return "Horse (Name - " + this.getName() +
                ", Breed  - " + this.getBreed() +
                ", Speed - " + this.speed + ")";
    }
}
