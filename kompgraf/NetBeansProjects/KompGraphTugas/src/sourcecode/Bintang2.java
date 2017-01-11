package sourcecode;

import java.applet.Applet;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Bintang2 extends Applet {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    public void paint(Graphics g) {
        int[] x = new int[20];
        int[] y = new int[20];
        super.paint(g);
        int r = 100, segi = 15, x0 = 100, y0 = 100;
        int sudut = (int) 360 / segi;
        for (int i = 0; i < segi; i++) {
            x[i] = (int) Math.round(x0 + r * Math.cos(degToRad(sudut * i - 90)));
            y[i] = (int) Math.round(y0 + r * Math.sin(degToRad(sudut * i - 90)));
        }
        for (int i = 0; i < segi - 1; i++) {
            for (int j = i + 2; j < segi; j++) {
                if (i == 0 && j == segi - 1) {
                    continue;
                }
                g.drawLine(x[i], y[i], x[j], y[j]);
            }
        }
    }
}
