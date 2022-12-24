package lesson14.homework;

public class IncomingCall {
    private String callId;
    private String callPurpose;

    public static String[] callPurposes = new String[]{"Problem with something", "Prank call", "Business call", "Express gratitude", "Buy something", "Return of something", "Call to the police", "Got it wrong"};


    public IncomingCall(String callId, String callPurpose) {
        this.callId = callId;
        this.callPurpose = callPurpose;
    }

    public String getCallId() {
        return callId;
    }

    public String getCallPurpose() {
        return callPurpose;
    }

    public static String getRandomId() {
        return String.valueOf((int) (Math.random() * 20 + 1));
    }
}