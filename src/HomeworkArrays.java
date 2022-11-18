import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        task3();
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
