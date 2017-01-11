import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;

public class test2D extends JFrame
{
 public test2D()
 {
  super("Contoh Membuat Piring Terbang");
  setSize(500,300);
  setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }
 
 public void paint(Graphics g)
 {
  // Cast Graphics to Graphics2D
 	Graphics2D g2d = (Graphics2D)g;

 	Shape s = new Ellipse2D.Double(0, 0, 100, 100);
 	g2d.draw(s); // outline
 	//g2d.fill(s); // solid

 }
 
 public static void main (String [] args)
 {
  test2D app = new test2D();
 }
}