import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
 public class MencobaGradien extends JPanel{
    public static void main(String[] args){
       JFrame f = new JFrame("Basic Sample 2D");
       MencobaGradien bs = new MencobaGradien();
       f.getContentPane().add("Center",bs);
       f.pack();
       f.setSize(new Dimension(300,300));
       f.setVisible(true);
    }   
    public void paintComponent(Graphics g){
       
     Graphics2D g2d = (Graphics2D)g;
      //fill elipse2D.Double
     GradientPaint gp4 = new GradientPaint(0,25,
            Color.blue,25,25, Color.black,true);
    g2d.setPaint(gp4);
    g2d.fillRect(20,20,300,40);
    }   
}
