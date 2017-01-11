import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
 public class BasicSample2D extends JPanel{
    public static void main(String[] args){
       JFrame f = new JFrame("Basic Sample 2D");
       BasicSample2D bs = new BasicSample2D();
       f.getContentPane().add("Center",bs);
       f.pack();
       f.setSize(new Dimension(300,300));
       f.setVisible(true);
    }   
    public void paintComponent(Graphics g){
        
    Graphics2D g2d = (Graphics2D)g;  
 g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
g2d.setColor(Color.CYAN);
g2d.draw(new Rectangle2D.Double(300, 50, 200, 100));
  
// Test dash-stroke
float[] dashPattern = {20, 5, 10, 5};  // dash, space, dash, space
g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
      10, dashPattern, 0));
g2d.setColor(Color.CYAN);
g2d.draw(new Rectangle2D.Double(50, 200, 200, 100));
  }
}
