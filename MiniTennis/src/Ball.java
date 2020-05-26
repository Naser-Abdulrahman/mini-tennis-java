import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 100;
    int xa = 3;
    int ya = 3;
    private final Game game;


    public Ball(Game game) {
        this.game = game;
    }

    int move() {
        //Each of these if statements checks if the ball is at one of the 4 boarders of the canvas
        //once it reaches one of them, the ball will bonce off the wall in the opposite direction it came from with respect to x and y
        if (x + xa < 0) xa = 3;
        if (x + xa > game.getWidth() - DIAMETER) xa = -3;
        if (y + ya < 0) ya = 3;
        if (y + ya > game.getHeight() - DIAMETER) game.gameOver();
        if (collision()){
            ya = -3;
            y = game.racquet.getTop() - DIAMETER;
        }
        if (aiCollision()) {
            ya = 3;
            y = game.ai.getBottom() + DIAMETER;
        }
        x += xa;
        y += ya;
        return x;
    }
    public void paint (Graphics2D g) {
        g.fillOval(x,y,DIAMETER, DIAMETER);
    }

    private boolean collision() {
        return  game.racquet.getBounds().intersects(getBounds());
    }

    private boolean aiCollision() { return game.ai.getBounds().intersects(getBounds());}

    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }
}
