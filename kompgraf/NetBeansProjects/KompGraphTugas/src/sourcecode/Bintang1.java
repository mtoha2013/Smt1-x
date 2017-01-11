package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Bintang1 extends Applet {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    public void paint(Graphics g) {
        int[] x = new int[20];
        int[] y = new int[20];
        super.paint(g);
        int r = 100, x0 = 100, y0 = 100;
        int sudut = (int) 360 / 5;
        for (int i = 0; i < 5; i++) {
            x[i] = (int) Math.round(x0 + r * Math.cos(degToRad(sudut * i)));
            y[i] = (int) Math.round(y0 + r * Math.sin(degToRad(sudut * i)));
        }
        for (int i = 0; i < 5 - 1; i++) {
            for (int j = i + 2; j < 5; j++) {
                if (i == 0 && j == 4) {
                    continue;
                }
                g.drawLine(x[i], y[i], x[j], y[j]);
            }
        }
    }
}
