package emailapp;

public enum MailBoxCapacity {

    SALES(600),
    DEVELOPMENT(400),
    ACCOUNTING(800);

    private int capacity;

    MailBoxCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
