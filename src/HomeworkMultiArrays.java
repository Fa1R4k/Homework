import java.util.Arrays;
import java.util.Scanner;

public class HomeworkMultiArrays {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension: ");
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
        System.out.print("Enter array dimension: ");
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


    private static String numReplace(int num) {
        switch (num) {
            case 1 -> {
                return "One";
            }
            case 2 -> {
                return "Two";
            }
            case 3 -> {
                return "Three";
            }
            case 4 -> {
                return "Four";
            }
            case 5 -> {
                return "Five";
            }
            case 6 -> {
                return "Six";
            }
            case 7 -> {
                return "Seven";
            }
            case 8 -> {
                return "Eight";
            }
            case 9 -> {
                return "Nine";
            }
            case 10 -> {
                return "Ten";
            }
        }
        return "null";
    }
}
