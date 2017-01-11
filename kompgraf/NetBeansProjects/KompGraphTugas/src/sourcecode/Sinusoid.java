package sourcecode;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

class Sinusoid extends JPanel {

    double degToRad(int deg) {
        return ((2 * 3.14) / 360) * deg;
    }

    int scale(int i) {
        return (int) ((i / 300.0) * 720.0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 300; i++) {
            g2d.drawLine(i, (int) Math.round((-Math.sin(degToRad(scale(i))) + 1) * 100),
                    i, (int) Math.round((-Math.sin(degToRad(scale(i))) + 1) * 100));
        }
    }

    public static void main(String[] aaa) {
        JFrame frame = new JFrame("Sekarang pake Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sinusoid sn = new Sinusoid();
        sn.setPreferredSize(new Dimension(600, 600));
        frame.getContentPane().add(sn);
        frame.pack();
        frame.setVisible(true);
    }
}
