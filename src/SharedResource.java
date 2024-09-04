public class SharedResource {
    private int data;

    public SharedResource(int initialData) {
        this.data = initialData;
    }

    public synchronized void modifyData(int value) {
        data += value;
    }

    public int getData() {
        return data;
    }
}