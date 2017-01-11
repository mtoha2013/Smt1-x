package sourcecode;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

class ajibStar extends JPanel {

    static double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random acak = new Random();
        Color[] warna = {Color.red, Color.blue, Color.black, Color.cyan, Color.yellow, Color.green, Color.orange, Color.pink};
        int r, segi, x0, y0;
        for (int i = 0; i < 50; i++) {
            r = acak.nextInt(90) + 10;
            segi = acak.nextInt(10) + 5;
            x0 = acak.nextInt(300) + 100;
            y0 = acak.nextInt(300) + 100;
            gbrBintang(g, r, segi, x0, y0, warna[i % 8]);
        }
    }

    private void gbrBintang(Graphics g, int r, int segi, int x0, int y0, Color warna) {
        int[] x = new int[segi];
        int[] y = new int[segi];
        int sudut = (int) 360 / segi;
        for (int i = 0; i < segi; i++) {
            x[i] = (int) Math.round(x0 + r * Math.cos(degToRad(sudut * i - 90)));
            y[i] = (int) Math.round(y0 + r * Math.sin(degToRad(sudut * i - 90)));
        }
        g.setColor(warna);
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
