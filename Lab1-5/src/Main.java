public class Main {
    public static void main(String[] args) {
//        PrinterRunnable dashRunnable = new PrinterRunnable("-");
//        PrinterRunnable pipeRunnable = new PrinterRunnable("|\n");
//
//        Thread dashThread = new Thread(dashRunnable);
//        Thread pipeThread = new Thread(pipeRunnable);
//
//        dashThread.start();
//        pipeThread.start();

        Object lock = new Object();
        PrinterRunnableFixed dashRunnable = new PrinterRunnableFixed("-", lock);
        PrinterRunnableFixed pipeRunnable = new PrinterRunnableFixed("|\n", lock);

        Thread dashThread = new Thread(dashRunnable);
        Thread pipeThread = new Thread(pipeRunnable);

        dashThread.start();
        pipeThread.start();
    }
}
