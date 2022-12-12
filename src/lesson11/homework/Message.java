package lesson11.homework;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Message {
    private User sender;
    private String messageContent;
    private Calendar messageTime;

    public Message(User sender, String messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
        this.messageTime = new GregorianCalendar();
    }

    public void printMessage() {
        System.out.println("\n From: " + sender.getName() +
                "\n Content: " + messageContent +
                "\n Time: " + messageTime.getTime() + "\n");
    }
}
