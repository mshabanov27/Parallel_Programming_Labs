public class CounterRunnable implements Runnable{

    private final Sync sync;

    private boolean controlValue;
    private Counter counter;

    public CounterRunnable(Sync sync, boolean controlValue, Counter counter) {
        this.sync = sync;
        this.controlValue = controlValue;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true){
            sync.waitAndChange(controlValue, counter);
            if (sync.isStop()){
                return;
            }
        }
    }


}
