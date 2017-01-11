package upm.soal;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;

public class GradientPaintSample extends JPanel
{   
    private GradientPaint gradasi = new GradientPaint(0,0,Color.yellow, 175,175,Color.red, true);
    private Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, 350, 350);
    private Rectangle2D.Double square = new Rectangle2D.Double(10, 10, 350, 350);
    
    public void paintComponent(Graphics g)
    {   
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradasi);
        g2d.fill(circle);
        g2d.setPaint(Color.black);
        g2d.draw(circle);
        g2d.draw(square);
    }
    
    public static void main (String[]args){
     JFrame fr = new JFrame();
        fr.setSize(500,500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GradientPaintSample gps = new GradientPaintSample();
        fr.add(gps);
        fr.setVisible(true);
    }
}