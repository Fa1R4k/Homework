package lesson10.homework;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер вашего документа: ");
        String documentNumber = scanner.nextLine();
        while (!DocumentLogic.checkCorrectnessDocument(documentNumber)) {
            System.out.print("Не верный номер документ. Повторите попытку: ");
            documentNumber = scanner.nextLine();
        }
        DocumentLogic.printAllInfo(documentNumber);
    }
}
