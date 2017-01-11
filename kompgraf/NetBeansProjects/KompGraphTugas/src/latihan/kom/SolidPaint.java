package latihan.kom;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;

public class SolidPaint extends Applet {

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Arc2D pie = new Arc2D.Float(0, 50, 150, 150,
                -30, 90, Arc2D.PIE);
        g2.setPaint(Color.blue);
        g2.fill(pie);
    }
}
