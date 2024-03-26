public class RedThread extends Thread {
    private Ball b;
    private BlueThread blueThread;

    public RedThread(Ball ball, BlueThread blueThread){
        b = ball;
        this.blueThread = blueThread;
    }

    @Override
    public void run(){
        try {
            blueThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        try{
            for(int i=1; i<500; i++){
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);

            }
        } catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}