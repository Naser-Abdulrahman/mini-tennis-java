import java.awt.Graphics2D;

public class Ball {
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game2 game;

    public Ball(Game2 game) {
        this.game = game;
    }

    void move() {
        //Each of these if statements checks if the ball is at one of the 4 boarders of the canvas
        //once it reaches one of them, the ball will bonce off the wall in the opposite direction it came from with respect to x and y
        if (x + xa < 0) xa = 1;
        if (x + xa > game.getWidth() - 30) xa = -1;
        if (y + ya < 0) ya = 1;
        if (y + ya > game.getHeight() - 30) ya = -1;
        x += xa;
        y += ya;
    }

    public void paint(Graphics2D g){
        g.fillOval(x,y,30,30);
    }
}
