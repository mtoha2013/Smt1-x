package sourcecode;

import javax.swing.*;
import java.awt.*;

class UTSno3 extends JFrame {

    public static void main(String[] args) {
        new UTSno3();
    }

    UTSno3() {
        super("UTS no. 3");
        setSize(800, 600);
        setVisible(true);
    }

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    public void paint(Graphics g) {
        int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
        int[] y = new int[26];
        for (int i = 0; i < 25; i++) {
            y[i] = (int) Math.round(40 * Math.sin((i * 40) * (3.14 / 180)) + 2 * i);//+2*(i*2)+25);
            if (y[i] > ymax) {
                ymax = y[i];
            }
            if (y[i] < ymin) {
                ymin = y[i];
            }
            //System.out.println((i*2)+"\t"+y[i]);
        }
        double skala = 500.0 / (ymax - ymin);
        for (int i = 1; i < 25; i++) {
            g.drawLine((i - 1) * 30, 450 - ((int) (y[i - 1] * skala)), i * 30, 450 - ((int) (y[i] * skala)));
        }
    }
}
