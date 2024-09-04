public class Thread2 implements Runnable{

    private final SharedResource resource;

    public Thread2(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
      resource.modifyData(-1);
      }
    }
}
