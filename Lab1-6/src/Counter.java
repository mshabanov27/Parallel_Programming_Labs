public class Counter {
    private int count = 0;

    public void increment (){
        count++;
    }

    public void decrement (){
        count--;
    }

    public synchronized void syncIncrement (){
        count++;
    }

    public synchronized void syncDecrement (){
        count--;
    }

    public void syncBlockIncrement (){
        synchronized (this){
            count++;
        }
    }

    public void syncBlockDecrement (){
        synchronized (this){
            count--;
        }
    }

//    public void objectBlockIncrement() {
//        while (true){
//            sync.waitAndIncrement(controlValue, count);
//            if (sync.isStop()){
//                return;
//            }
//        }
//    }
//
//    public void objectBlockDecrement() {
//        while (true){
//            sync.waitAndDecrement(controlValue, count);
//            if (sync.isStop()){
//                return;
//            }
//        }
//    }

    public int getCount() {
        return count;
    }
}
