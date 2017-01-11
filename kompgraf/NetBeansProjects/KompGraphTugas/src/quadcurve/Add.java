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
 public class Add extends JPanel{
    public static void main(String[] args){
       JFrame f = new JFrame("Basic Sample 2D");
       Add bs = new Add();
       f.getContentPane().add("Center",bs);
       f.pack();
       f.setSize(new Dimension(200,200));
       f.setVisible(true);
    }   
 
 public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D)g;  
    Shape s1 = new Ellipse2D.Double(0, 0, 100, 100);
    Shape s2 = new Ellipse2D.Double(60, 0, 100, 100);
    Area a1 = new Area(s1);
    Area a2 = new Area(s2);
    BasicStroke bsThickLine = new BasicStroke(111.0f);
    g2.setStroke(bsThickLine);
    g2.setPaint(Color.blue);
    g2.draw(s1);
    g2.draw(s2);
    a2.add(a1);
    g2.setPaint(Color.green);
    g2.fill(a2);
    }
}
