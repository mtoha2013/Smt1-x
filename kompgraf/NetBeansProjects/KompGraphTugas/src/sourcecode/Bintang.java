package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;

public class Bintang extends Applet {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }
    // static int scale(int i) {
    //   return (int)((i/300.0)*720.0);
    //}

    public void paint(Graphics g) {
        int r = 50;
        int sudut = 0;
        int[] x = new int[20];
        int[] y = new int[20];
        super.paint(g);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                sudut = i * 36;
                r = 50;
            } else {
                sudut = i * 36;
                r = 20;
            }
            x[i] = (int) Math.round(100 + r * Math.cos(degToRad(sudut)));
            y[i] = (int) Math.round(100 + r * Math.sin(degToRad(sudut)));
        }
        for (int i = 1; i < 10; i++) {
            g.drawLine(x[i - 1], y[i - 1], x[i], y[i]);
        }
    }
}
