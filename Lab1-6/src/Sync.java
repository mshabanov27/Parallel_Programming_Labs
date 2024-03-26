import java.util.logging.Level;
import java.util.logging.Logger;

public class Sync {
    private boolean permission = true;

    private int num = 0;
    private boolean stop = false;

    public synchronized void waitAndChange(boolean controlValue, Counter counter) {
        while(permission!=controlValue){
            try{
                wait();
            }
            catch (InterruptedException e){
                Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        if (permission)
            counter.increment();
        else
            counter.decrement();

        permission = !permission;
        num++;
        if (num + 1 == 200_000)
            stop = true;

        notifyAll();
    }

    public boolean isStop() {
        return stop;
    }
}
