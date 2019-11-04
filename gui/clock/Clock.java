package gui.clock;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author VyVu
 */
public class Clock extends JPanel{
    private Graphics2D g2D;
    private Ellipse2D clock;
    private final int dC=200;
    private final int line=10;
    private GeneralPath gen;
    public Clock() {
        setSize(500, 500);
        clock=new Ellipse2D.Double(0, 0, dC, dC);
        gen=new GeneralPath();
        gen.moveTo(clock.getBounds2D().getX(),clock.getBounds2D().getY()+clock.getBounds2D().getWidth()/2);
        gen.lineTo(clock.getBounds2D().getX()+line,clock.getBounds2D().getY()+clock.getBounds2D().getWidth()/2+line);
        gen.closePath();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D=(Graphics2D) g.create();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setStroke(new BasicStroke(3));
        clockPaint();
    }

    private void clockPaint() {
        for(int i=0;i<=360;i+=6){
            AffineTransform save=g2D.getTransform();
            AffineTransform at=(AffineTransform) save.clone();
            at.rotate(Math.toRadians(i), getWidth()/2,getHeight()/2);
            at.translate(getWidth()/2-dC/2, getHeight()/2-dC/2);
            g2D.transform(at);
            g2D.draw(gen);
            g2D.draw(clock);
            g2D.setTransform(save);
        }
    }
    public static void main(String[] args) {
        JFrame frame =new JFrame();
        frame.setSize(500, 500);
        frame.add(new Clock());
        frame.setVisible(true);
    }
}
