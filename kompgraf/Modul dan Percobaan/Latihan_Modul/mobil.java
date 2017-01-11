import java.awt.*;
   public class mobil extends java.applet.Applet {
       public void paint(Graphics g) {
       g.setColor(Color.black);
        g.fillRect(50, 230, 350, 75);  
        g.setColor(Color.gray);
      g.fillRect(50, 220, 250, 5);
      g.fillRect(50, 210, 250, 5);    
      g.fillRect(50, 200, 250, 5); 
      g.fillRect(50, 200, 5, 20);
      g.fillRect(295, 200, 5, 20);
     g.fillRect(50, 95, 250, 100); 
     g.fillRoundRect(310, 95, 90, 130, 20, 20);
     g.fillRoundRect(350, 155, 120, 70, 20, 20);
   }
}

