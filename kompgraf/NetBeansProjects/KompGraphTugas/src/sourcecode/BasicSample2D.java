package sourcecode;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class BasicSample2D extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame("Basic Sample 2D");
        BasicSample2D bs = new BasicSample2D();
        f.getContentPane().add("Center", bs);
        f.pack();
        f.setSize(new Dimension(200, 200));
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        // Cast Graphics to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        Shape s = new QuadCurve2D.Double(25, 50, 50, 0, 100, 50);
        g2d.fill(s); // outline
        //g2d.fill(s); // solid

        Shape s2 = new QuadCurve2D.Double(50, 150, 50, 0, 100, 50);
        g2d.fill(s2);
    }
}
