public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball){
        b = ball;
    }
    @Override
    public void run(){
        try{
            boolean isInPool = false;
            for(int i=1; i<10000 && !isInPool; i++){
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);

                if (b.getX() < 20  && b.getY() < 20  ||
                    b.getX() < 20  && b.getY() > b.getCanvas().getHeight() - 30 ||
                    b.getX() > b.getCanvas().getWidth() - 30 && b.getY() < 20  ||
                    b.getX() > b.getCanvas().getWidth() - 30 && b.getY() > b.getCanvas().getHeight() - 30)
                {
                    Thread.currentThread().interrupt();
                    if (Thread.interrupted()){
                        isInPool = true;
                        b.getCanvas().delete_ball(this.b);
                        b.getCanvas().repaint();
                    }
                }
            }
        } catch(InterruptedException ex){
        }
    }
}