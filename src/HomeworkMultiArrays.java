import java.util.Arrays;
import java.util.Scanner;

public class HomeworkMultiArrays {
    public static void main(String[] args) {
        task1();
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
}
