public class PrinterRunnableFixed implements Runnable{
    private String symbol;
    private final Object sync;

    public PrinterRunnableFixed(String symbol, Object sync) {
        this.symbol = symbol;
        this.sync = sync;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (sync){
                System.out.print(symbol);
                sync.notify();
                try {
                    sync.wait(1);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
