import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
    Ball ball = new Ball(this);


    private void move(){
        ball.move();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g); //This will clear the canvas, so we dont see the ball in an old position
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        Game2 game = new Game2();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e){
                System.out.println("You broke it");
            }
        }
    }
}
