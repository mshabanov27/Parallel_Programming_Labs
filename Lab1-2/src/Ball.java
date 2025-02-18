import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private BallCanvas canvas;

    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;


    public Ball(BallCanvas c){
        this.canvas = c;


        if(Math.random()<0.5){
            x = new Random().nextInt(3*XSIZE, this.canvas.getWidth() - 3*XSIZE);
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(3*YSIZE, this.canvas.getHeight() - 3*YSIZE);
        }
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));
    }

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+XSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+YSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BallCanvas getCanvas() {
        return this.canvas;
    }
}
