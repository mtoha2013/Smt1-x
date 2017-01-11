package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;

public class SinEx extends Applet {

    double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    int scale(int i) {
        return (int) ((i / 300.0) * 720.0);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x1, y1, r = 20;
        for (int i = 45; i <= 90; i += 15) {
            double s = Math.toRadians(i);
            x1 = (int) (-r * Math.cos(s));
            y1 = (int) (r * Math.sin(s));
            g.drawLine(150, 200, -x1, y1);
        }
    }
}
