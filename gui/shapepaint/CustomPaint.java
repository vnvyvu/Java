package gui.shapepaint;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author VyVu
 */
public class CustomPaint extends JPanel{
    private GeneralPath gen;
    private int sellect;
    private Point2D[] p;
    private int offset[];
    public CustomPaint(GeneralPath gen, int sellect, Point2D[] p) {
        this.gen = gen;
        this.sellect = sellect;
        this.p = p;
        this.offset=offset;
        initData();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D=(Graphics2D) g.create();
        g2D.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2D.setStroke(new BasicStroke(3));
        if(sellect==1) g2D.draw(gen);
        else if(sellect==2) g2D.fill(gen);
    }

    private void initData() {
        int i=1;
        gen.moveTo(p[0].getX(), p[0].getY());
        while(i<p.length){
            gen.lineTo(p[i].getX(), p[i].getY());
            i++;
        }
    }
    
}
