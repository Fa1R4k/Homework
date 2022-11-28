package other;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkMultiArrays {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension[2 numbers]: ");
        int countArr = scanner.nextInt();
        int lengthArr = scanner.nextInt();
        int[] array = new int[countArr * lengthArr];
        int[][] twoDimensionalArray = new int[countArr][lengthArr];
        int temp = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                twoDimensionalArray[i][j] = (int) (Math.random() * 1000);
                array[temp] = twoDimensionalArray[i][j];
                temp++;
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(array));
    }

    private static void task2() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension[3 numbers]: ");
        int firstLength = scanner.nextInt();
        int secondLength = scanner.nextInt();
        int thirdLength = scanner.nextInt();
        int[][][] threeDimensionalArray = new int[firstLength][secondLength][thirdLength];
        String[][][] stringThreeDimensionalArray = new String[firstLength][secondLength][thirdLength];

        for (int i = 0; i < threeDimensionalArray.length; i++) {
            for (int j = 0; j < threeDimensionalArray[i].length; j++) {
                for (int k = 0; k < threeDimensionalArray[i][j].length; k++) {
                    threeDimensionalArray[i][j][k] = (int) (Math.random() * 10 + 1);
                    stringThreeDimensionalArray[i][j][k] = numReplace(threeDimensionalArray[i][j][k]);
                }
            }
        }
        System.out.println(Arrays.deepToString(threeDimensionalArray));
        System.out.println(Arrays.deepToString(stringThreeDimensionalArray));
    }

    private static void task3() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension[2 numbers]: ");
        int[][] twoDimensionalArray = new int[scanner.nextInt()][scanner.nextInt()];

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                twoDimensionalArray[i][j] = (int) (Math.random() * 1000);
            }
        }
        System.out.println(Arrays.deepToString(twoDimensionalArray));
        System.out.println("Your numbers: ");
        int num = scanner.nextInt();

        for (int[] ints : twoDimensionalArray) {
            for (int anInt : ints) {
                if (anInt % num == 0) {
                    System.out.println(anInt + " - number found!");
                    return;
                } else {
                    System.out.println(anInt + " ");
                }
            }
        }
        System.out.println("The number was not found");
    }

    private static String numReplace(int num) {
        return switch (num) {
            case 1 -> "One";

            case 2 -> "Two";

            case 3 -> "Three";

            case 4 -> "Four";

            case 5 -> "Five";

            case 6 -> "Six";

            case 7 -> "Seven";

            case 8 -> "Eight";

            case 9 -> "Nine";

            case 10 -> "Ten";

            default -> "null";
        };
    }
}
