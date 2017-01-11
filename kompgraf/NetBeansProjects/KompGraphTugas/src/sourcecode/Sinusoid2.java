package sourcecode;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;

public class Sinusoid2 extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random r1 = new Random();
        int rval, gval, bval;

        for (int i = 0; i < 50; i++) {
            int x = r1.nextInt(200);
            int y = r1.nextInt(300);
            int l = 10 + r1.nextInt(100);
            int t = 10 + r1.nextInt(40);

            rval = (int) Math.floor(Math.random() * 256);
            gval = (int) Math.floor(Math.random() * 256);
            bval = (int) Math.floor(Math.random() * 256);
            g.setColor(new Color(rval, gval, bval));
            //g.drawRect(x,y,l,t);

            g.fillRect(x, y, l, t);
        }
    }

    public static void main(String[] aaa) {
        JFrame fr = new JFrame("Sekarang pake Label");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sinusoid2 sn2 = new Sinusoid2();
        sn2.setPreferredSize(new Dimension(600, 600));
        fr.getContentPane().add(sn2);
        fr.pack();
        fr.setVisible(true);
    }
}
