/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadcurve;

/**
 *
 * @author MToha 201643570041
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class MyArc extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame("Basic Sample 2D");
        MyArc bs = new MyArc();
        f.getContentPane().add("Center", bs);
        f.pack();
        f.setSize(new Dimension(200, 200));
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        // Cast Graphics to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        Shape s = new Arc2D.Double(20, 30, 100, 80, 45, 280,Arc2D.CHORD);
        g2d.draw(s); // outline
        //g2d.fill(s); // solid
    }
}
