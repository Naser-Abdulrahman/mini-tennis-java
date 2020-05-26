import java.awt.*;
import java.awt.event.KeyEvent;

public class AI {
    private static final int Y = 40;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static final int BOTTOM = Y+HEIGHT;
    int x = 0;
    int xa = 0;
    private Game game;

    public AI(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) x+=xa;
    }

    public void paint (Graphics2D g) {
        g.fillRect(x,Y,WIDTH,HEIGHT);
    }

    public void tracking (int tx) {
        if ( x < tx ) x+=3;
        if ( x > tx ) x+=-3;
    }
    public Rectangle getBounds() {
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }

    public int getBottom() { return BOTTOM;}

}
