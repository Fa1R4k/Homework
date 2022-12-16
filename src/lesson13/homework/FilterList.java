package lesson13.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterList {
    private static List<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        fillingArrayList();
        printArrayListWithDescription(arrayList, "You array: ");
        deleteDuplicate();
        printEvenElementsFrom7To17();
        multiplyAllElementsByTwo();
        removeElementsLessThanTen();
        printCountList();
        printArithmeticMean();
        printArrayListWithDescription(arrayList, "You array: ");
    }

    private static void fillingArrayList() {
        int size = getSizeFromConsole();
        for (int i = 0; i < size; i++) {
            arrayList.add((int) (Math.random() * 25 + 1));
        }
    }

    private static void printArrayListWithDescription(List<Integer> arrayList, String description) {
        System.out.println(description + arrayList);
    }

    private static int getSizeFromConsole() {
        System.out.print("Enter size of the array: ");
        Scanner scanner = new Scanner(System.in);
        String size;
        do {
            size = scanner.nextLine();
        } while (checkSizeForNumbers(size));

        return Integer.parseInt(size);
    }

    private static boolean checkSizeForNumbers(String size) {
        if (!size.matches("\\d+")) {
            System.out.print("Try again(Enter only numbers): ");
            return true;
        }
        return false;
    }

    private static void deleteDuplicate() {
        arrayList = arrayList.stream()
                .distinct()
                .toList();
        System.out.println("Duplicates have been deleted");
    }

    private static void multiplyAllElementsByTwo() {
        arrayList = arrayList.stream()
                .map(num -> num * 2)
                .toList();
        System.out.println("Each element is multiplied by two");
    }

    private static void printEvenElementsFrom7To17() {
        Predicate<Integer> predicate = num -> num % 2 == 0 && num < 17 && num > 7;
        List<Integer> listWithEvenElementsFrom7To17 = arrayList.stream()
                .filter(predicate)
                .toList();
        printArrayListWithDescription(listWithEvenElementsFrom7To17, "Even elements from 7 to 17: ");
    }

    private static void removeElementsLessThanTen() {
        Predicate<Integer> moreThatTen = n -> n > 10;
        arrayList = arrayList.stream()
                .sorted()
                .filter(moreThatTen)
                .toList();
        System.out.println("Elements less than 10 have been removed");
    }

    private static void printCountList() {
        long listSize = arrayList.stream()
                .count();
        System.out.println("Count elements is List: " + listSize);
    }

    private static void printArithmeticMean() {
        double arithmeticMean = (double) (arrayList.stream().reduce(0, Integer::sum)) / arrayList.size();
        System.out.println("The arithmetic mean of your array: " + arithmeticMean);
    }


}
