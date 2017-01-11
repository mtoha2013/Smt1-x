package sourcecode;

import java.awt.*;
import java.awt.event.*;

public class gambarGrafik extends Frame {

    public static void main(String[] args) {
        new gambarGrafik();
    }

    public gambarGrafik() {  //constructor
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
            g.drawLine(100, 300 - i * 50, 500, 300 - i * 50);
        }
        g.setColor(Color.blue);
        g.drawRect(100, 75, 400, 275);
        g.setColor(Color.black);
        int x0 = 100;
        g.drawString("Ini contoh gambar Grafik", 150, 375);
        for (int i = 1; i < y.length; i++) {
            g.drawLine(x0 + (i - 1) * 40, 350 - y[i - 1], x0 + i * 40, 350 - y[i]);
        }
    }
}
