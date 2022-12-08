package lesson10.homework;

public class DocumentLogic {

    private static final String REGEX_DOCUMENT = "\\d{4}-[A-z]{3}-\\d{4}-[A-z]{3}-\\d[A-z]\\d[A-z]";

    public static boolean checkCorrectnessDocument(String documentNumber) {
        return documentNumber.matches(REGEX_DOCUMENT);
    }

    public static void printAllInfo(String documentNumber) {
        DocumentLogic.printDigitsBlocks(documentNumber);
        DocumentLogic.printHiddenNumber(documentNumber);
        DocumentLogic.printLettersFormat(documentNumber);
        DocumentLogic.checkABCSequence(documentNumber);
        DocumentLogic.checkEndsNumber(documentNumber);
    }

    private static void printDigitsBlocks(String documentNumber) {
        System.out.println(documentNumber.substring(0, 4) + documentNumber.substring(8, 13));
    }

    private static void printHiddenNumber(String documentNumber) {
        String hiddenNumber = documentNumber.replaceAll("[A-z]", "*");
        System.out.println(hiddenNumber);
    }

    private static void printLettersFormat(String documentNumber) {
        documentNumber = documentNumber.toUpperCase();
        StringBuilder documentNumberBuilder = new StringBuilder("Letters:");
        documentNumberBuilder
                .append(documentNumber, 5, 8).append("/")
                .append(documentNumber, 14, 17).append("/")
                .append(documentNumber, 19, 22)
                .deleteCharAt(documentNumberBuilder.length() - 2);
        System.out.println(documentNumberBuilder);
    }

    private static void checkABCSequence(String documentNumber) {
        documentNumber = documentNumber.toLowerCase();
        System.out.println("Ваш номер " + (documentNumber.contains("abc") ? "содержит " : "не содержит ")
                + "последовательность \"abc\"");
    }

    private static void checkEndsNumber(String documentNumber) {
        System.out.println("Ваш номер заканчивается" + (documentNumber.endsWith("1a2b") ? " на " : " не на ")
                + "\"1a2b\"");
    }
}