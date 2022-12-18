package lesson13.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterList {
    public static void main(String[] args) {
        List<Integer> arrayList = fillingArrayList();
        Predicate<Integer> predicateMoreThatTen = n -> n > 10;
        printArrayListWithDescription(arrayList, "You array: ");
        arrayList = arrayList.stream()
                .distinct()
                .peek(num -> {
                    if (num % 2 == 0 && num < 17 && num > 7) {
                        System.out.print(num + " ");
                    }
                })
                .map(num -> num * 2)
                .filter(predicateMoreThatTen)
                .toList();
        printCountList(arrayList);
        printArithmeticMean(arrayList);
        printArrayListWithDescription(arrayList, "You array: ");
    }

    private static List<Integer> fillingArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        int size = getSizeFromConsole();
        for (int i = 0; i < size; i++) {
            arrayList.add((int) (Math.random() * 25 + 1));
        }
        return arrayList;
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

    private static void printCountList(List<Integer> arrayList) {
        long listSize = arrayList.stream()
                .count();
        System.out.println("\nCount elements is List: " + listSize);
    }

    private static void printArithmeticMean(List<Integer> arrayList) {
        double arithmeticMean = (double) (arrayList.stream().reduce(0, Integer::sum)) / arrayList.size();
        System.out.println("The arithmetic mean of your array: " + arithmeticMean);
    }
}
