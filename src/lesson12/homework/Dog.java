package lesson12.homework;

public class Dog extends Pet {
    private int age;

    public Dog(String name, String breed, int age) {
        super(name, breed);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog (Name - " + this.getName() +
                ", Breed  - " + this.getBreed() +
                ", Age - " + this.age + ")";
    }
}
