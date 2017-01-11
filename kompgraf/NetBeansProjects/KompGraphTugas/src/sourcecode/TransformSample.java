package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class TransformSample extends Applet {

    private GradientPaint gradasi = new GradientPaint(0, 0, Color.red, 175, 175, Color.yellow, true);
    private Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, 350, 350);
    private Color[] colors = {Color.blue, Color.green};

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGradientCircle(g2d);
        drawThickCircleOutline(g2d);
        setFont(new Font("Arial", Font.PLAIN, 35));
        drawRotateString(g2d);
    }

    private void drawGradientCircle(Graphics2D g2d) {
        g2d.setPaint(gradasi);
        g2d.fill(circle);
    }

    private void drawThickCircleOutline(Graphics2D g2d) {
        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(8));
        g2d.draw(circle);
    }

    private void drawRotateString(Graphics2D g2d) {
        g2d.translate(180.0, 180.0);
        for (int i = 0; i < 16; i++) {
            g2d.rotate(Math.PI / 8.0);
            g2d.setPaint(colors[i % 2]);
            g2d.drawString("UNINDRA", 0, 0);
        }
    }
}
