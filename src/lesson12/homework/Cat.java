package lesson12.homework;

public class Cat extends Pet{
    private String color;

    public Cat(String name, String breed, String color) {
        super(name, breed);
        this.color = color;
    }

    public String toString() {
        return "Cat (Name - " + this.getName() +
                ", Breed  - " + this.getBreed() +
                ", Color - " + this.color + ")";
    }
}
