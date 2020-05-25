package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Board extends JPanel {

    private Image bardejov;

    public Board(){
        initBoard();
    }
    private void initBoard(){
        loadImage();

        int w = bardejov.getWidth(this);
        int h = bardejov.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }
    private void loadImage() {
        ImageIcon ii = new ImageIcon("src/Game/images/alien.png");
        bardejov = ii.getImage();
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(bardejov, 0, 0, null);
    }
    /*
    private void drawDonut(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        //The rendering method helps makes the lines smoother, thus increasing the quality of the drawing
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        Dimension size = getSize();         //This gets the dimensions of the window, to centre the donut on there
        double h = size.getHeight();
        double w = size.getWidth();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        for (double deg = 0; deg < 360; deg += 5){
            AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }*/
}
