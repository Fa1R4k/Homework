package lesson12.homework;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    private static HashMap<String, Pet> pets = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        buildApp();
    }

    public static void buildApp() {
        createPets();
        while (!pets.isEmpty()) {
            printPets();
            deletePet(getConsolePet());
        }
        System.out.println("You list is empty. Goodbye!");
    }

    private static void createPets() {
        Pet murka = new Cat("Myrka", "Cyprus", "Black");
        Pet sharik = new Dog("Sharik", "Mongrel", 2);
        Pet tom = new Cat("Tom", "British", "Grey");
        Pet bucephalus = new Horse("Bucephalus", "Akhateke", 71.7);
        Pet schrodinger = new Cat("Schrodinger", "Unknown", "Unknown");
        pets.put(murka.getName(), murka);
        pets.put(sharik.getName(), sharik);
        pets.put(tom.getName(), tom);
        pets.put(bucephalus.getName(), bucephalus);
        pets.put(schrodinger.getName(), schrodinger);
    }

    private static void printPets() {
        for (Pet pet : pets.values()) {
            System.out.println(pet.toString());
        }
    }

    private static void deletePet(Pet pet) {
        System.out.println(pet.toString() + " was successful delete.\n");
        pets.remove(pet.getName());
    }

    private static Pet getConsolePet() {
        System.out.print("\nEnter the name of the pet you want to delete: ");
        String petName;
        do {
            petName = scanner.nextLine();
        } while (containsPet(petName));
        return pets.get(petName);
    }

    private static boolean containsPet(String petName) {
        if (!pets.containsKey(petName)) {
            System.out.print("\nYour name is not in the list. Try again: ");
            return true;
        }
        return false;
    }
}
