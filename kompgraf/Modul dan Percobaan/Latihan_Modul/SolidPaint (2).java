import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class SolidPaint extends JPanel
{
		public static void main(String[] args) 
		{
				 JFrame f = new JFrame("Basic Sample 2D");
       SolidPaint bs = new SolidPaint();
       f.getContentPane().add("Center",bs);
       f.pack();
       f.setSize(new Dimension(300,300));
       f.setVisible(true);
		}
		
		public void paint(Graphics g) 
		{
				Graphics2D g2 = (Graphics2D)g;
				Arc2D pie = new Arc2D.Float(0, 50, 150, 150, 
																	-30, 90, Arc2D.PIE);
				g2.setPaint(Color.blue);
				g2.fill(pie);
		}
}
