import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        task2();
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
}
