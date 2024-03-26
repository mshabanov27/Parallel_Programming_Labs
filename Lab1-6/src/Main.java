public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Sync sync = new Sync();

        CounterRunnable incrementRunnable = new CounterRunnable(sync, true, counter);
        CounterRunnable decrementRunnable = new CounterRunnable(sync, false, counter);

        Thread incThread = new Thread(incrementRunnable);
        Thread decThread = new Thread(decrementRunnable);

//        Thread incThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100_000; i++) {
//                    counter.syncBlockIncrement();
//                }
//            }
//        });
//
//        Thread decThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100_000; i++) {
//                    counter.syncBlockDecrement();
//                }
//            }
//        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(counter.getCount());
    }
}
