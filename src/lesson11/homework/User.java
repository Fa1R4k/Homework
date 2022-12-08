package lesson11.homework;

import java.util.ArrayDeque;

public class User {

    private String name;

    private ArrayDeque<Message> massageDeque = new ArrayDeque<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountMassages() {
        return massageDeque.size();
    }

    private void getMessage(Message message) {
        massageDeque.offer(message);
    }

    public void checkMessage() {
        if (massageDeque.peek() != null) {
            massageDeque.poll().printMessage();
        } else {
            System.out.println("You don't have any messages!\n");
        }
    }

    public void sendMessage(User user, String messageContext) {
        user.getMessage(new Message(this, messageContext));
    }
}
