package lesson14.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class CallCenter {
    static Deque<IncomingCall> incomingCalls = new ArrayDeque<>();

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            incomingCalls.add(new IncomingCall(IncomingCall.getRandomId(), IncomingCall.callPurposes[i]));
        }

        Runnable acceptCall = CallCenter::getCall;

        Thread worker1 = new Thread(acceptCall);
        Thread worker2 = new Thread(acceptCall);
        Thread worker3 = new Thread(acceptCall);

        worker1.setName("Billy");
        worker2.setName("Willy");
        worker3.setName("Gilly");

        worker1.start();
        worker2.start();
        worker3.start();
    }

    private static void getCall() {
        while (incomingCalls.peekFirst() != null) {
            synchronized (incomingCalls) {
                if (!incomingCalls.isEmpty()) {
                    try {
                        System.out.println("Call ID: " + incomingCalls.peekFirst().getCallId()
                                + ". Call purpose: " + incomingCalls.removeFirst().getCallPurpose()
                                + ". Processed by an employee: " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
