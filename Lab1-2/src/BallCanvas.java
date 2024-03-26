import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball b){
        this.balls.add(b);
    }

    public void delete_ball(Ball b){
        this.balls.remove(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.fillOval(0, 0, 30, 30);
        g2.fillOval(this.getWidth() - 30, 0, 30, 30);
        g2.fillOval(0, this.getHeight() - 30, 30, 30);
        g2.fillOval(this.getWidth() - 30, this.getHeight() - 30, 30, 30);

        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
    }
}
