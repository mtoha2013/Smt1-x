package sourcecode;

import java.awt.*;
import java.awt.event.*;

public class gambarGrafik2 extends Frame {

    public static void main(String[] args) {
        new gambarGrafik2();
    }

    public gambarGrafik2() {  //konstruktor
        super("Java 2D Example");
        setSize(600, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        int[] y = {25, 65, 75, 100, 175, 210, 160, 155, 200, 170, 220};
        g.setColor(Color.gray);
        for (int i = 0; i < 5; i++) {
            g.drawLine(100, 300 - i * 50, 515, 300 - i * 50);
        }
        g.setColor(Color.blue);
        g.drawRect(100, 75, 415, 275);
        g.setColor(Color.black);
        int x0 = 100, y0 = 0;
        g.drawString("Ini gambar Grafik", 150, 375);
        for (int i = 1; i < y.length; i++) {
            g.setColor(Color.black);
            g.drawString("" + y[i - 1], x0 + (i - 1) * 40, 350 - y[i - 1]);
            g.setColor(Color.red);
            g.drawLine(x0 + 15 + (i - 1) * 40, 350 - y[i - 1], x0 + 15 + i * 40, 350 - y[i]);
            g.fillOval(x0 + 10 + (i - 1) * 40, 345 - y[i - 1], 10, 10);
            g.setColor(Color.blue);
            try {
                g.setColor(Color.yellow);
                y0 = 0;
                for (int j = 5; y0 <= y[i - 1]; j += 5) {
                    g.fillRect(x0 + (i - 1) * 40, 350 - (y0 + 5), 30, 5);
                    y0 += 5;
                }
            } catch (Exception e) {
            }
        }
    }
}
