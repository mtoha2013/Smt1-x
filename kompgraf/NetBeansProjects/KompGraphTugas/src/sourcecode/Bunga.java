package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;

public class Bunga extends Applet {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    static int scale(int i) {
        return (int) ((i / 300.0) * 720.0);
    }

    public void paint(Graphics g) {
        int r = 50;
        int[] x = new int[20];
        int[] y = new int[20];
        super.paint(g);
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) Math.round(100 - r * Math.cos(degToRad((i * 15) + 45)));
            y[i] = (int) Math.round(100 - r * Math.sin(degToRad((i * 15) + 45)));
            g.drawLine(100, 100, x[i], y[i]);
        }
        g.drawLine(100, 100, 100, 150);
    }

}
