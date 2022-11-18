import java.util.Arrays;

public class HomeworkArrays {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        String[] names = new String[]{"Max", "Nikita", "Roma", "Andrey", "Denis"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
    }
}
