package gui.shapepaint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author VyVu
 */
public class EllipsePaint extends JPanel{
    private double x,y,w,h;
    private int sellect;
    public EllipsePaint(double x, double y, double w, double h, int sellect) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.sellect=sellect;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D=(Graphics2D) g.create();
        g2D.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2D.setStroke(new BasicStroke(3));
        if(sellect==1) g2D.draw(new Ellipse2D.Double(x, y, w, h));
        else if(sellect==2) g2D.fill(new Ellipse2D.Double(x, y, w, h));
    }
}
