public class Thread1 extends Thread{

    private final SharedResource resource;

    public Thread1(String threadName, SharedResource resource) {
        super(threadName);
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 90; i++){
            resource.modifyData(1);
        }
    }
}
