package upm.soal;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class garis_warna extends JApplet {

    public static void main(String s[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Kelompok 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new garis_warna();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }

//deklarasi objek panel2D
    public void init() {
        JPanel panel = new Panel2D();
        getContentPane().add(panel);
    }

}
//class panel2D untuk mempuat panel berukuran
//300 x 300 dengan warna putih

class Panel2D extends JPanel {

    public Panel2D() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.white);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
//garis dan Warna garis
        g2.setColor(Color.blue);
        g2.drawLine(100, 100, 200, 200);
        g2.setColor(Color.yellow);
        g2.drawLine(200, 100, 100, 200);
        g2.setColor(Color.red);
        g2.drawLine(200, 150, 100, 150);
        g2.setColor(Color.green);
        g2.drawLine(150, 100, 150, 200);

    }
}
