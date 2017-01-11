package sourcecode;

import javax.swing.JPanel;
import java.awt.*;

public class Taman extends java.applet.Applet {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    public void paint(Graphics g) {
        //super.paintComponent(g);
        garisBunga(50, 5, 50, 100, g);
    }

    private void garisBunga(int r, int n, int k, int t, Graphics g) {
        int[] x = new int[20];
        int[] y = new int[20];
        for (int i = 0; i < n; i++) {
            x[i] = (int) Math.round(k - r * Math.cos(degToRad((i * 15) + 45)));
            y[i] = (int) Math.round(t - r * Math.sin(degToRad((i * 15) + 45)));
            g.drawLine(k, t, x[i], y[i]);
        }
    }
}
