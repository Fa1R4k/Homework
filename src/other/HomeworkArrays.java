package other;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        String[] names = new String[]{"Max", "Nikita", "Roma", "Andrey", "Denis"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        boolean rightNum = true;
        int[] firstArray = new int[0];
        while (rightNum) {
            System.out.print("Введите число [6-10]: ");
            int arrayLength = scanner.nextInt();
            if (arrayLength > 5 && arrayLength <= 10) {
                rightNum = false;
                firstArray = new int[arrayLength];
                for (int i = 0; i < firstArray.length; i++) {
                    firstArray[i] = (int) (Math.random() * 100) + 1;
                }
            } else {
                System.out.println("Число введено неверно. Повторите попытку.");
            }
        }
        int countEvenNum = 0;
        for (int i : firstArray) {
            if (i % 2 == 0) {
                countEvenNum++;
            }
        }
        int[] secondArray = new int[countEvenNum];

        int indexSecondArray = 0;
        for (int i : firstArray) {
            if (i % 2 == 0) {
                secondArray[indexSecondArray] = i;
                indexSecondArray++;
            }
        }
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
    }

    private static void task3() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[(int) (Math.random() * 10 + 5)];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println("Ваш случайный массив - " + Arrays.toString(array));
        System.out.print("Введите удаляемое число: ");
        int deletedNum = scanner.nextInt();
        int countNumInArray = 0;
        for (int i : array) {
            if (i == deletedNum) {
                countNumInArray++;
            }
        }
        int lengthNewArray = array.length - countNumInArray;
        int[] arrayWithoutNum = new int[lengthNewArray];
        int indexNewArray = 0;
        for (int j : array) {
            if (j != deletedNum) {
                arrayWithoutNum[indexNewArray] = j;
                indexNewArray++;
            }
        }
        System.out.println("Массив без вашего числа - " + Arrays.toString(arrayWithoutNum));
    }
}
