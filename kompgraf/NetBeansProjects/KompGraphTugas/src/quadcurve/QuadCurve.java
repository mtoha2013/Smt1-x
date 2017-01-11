package quadcurve;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
//MToha 201643570041
public class QuadCurve extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame("Basic Sample 2D");
        QuadCurve bs = new QuadCurve();
        f.getContentPane().add("Center", bs);
        f.pack();
        f.setSize(new Dimension(200, 200));
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        // Cast Graphics to Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        Shape s = new QuadCurve2D.Double(25, 50, 20, -190, 100, 50);
        g2d.fill(s); // outline
        //g2d.fill(s); // solid
        Shape s2 = new QuadCurve2D.Double(25, 60, 50, 110, 100, 60);
        g2d.fill(s2);
    }
}
