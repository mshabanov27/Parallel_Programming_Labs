public class PrinterRunnable implements Runnable{
    private String symbol;

    public PrinterRunnable(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(symbol);
        }
    }
}
