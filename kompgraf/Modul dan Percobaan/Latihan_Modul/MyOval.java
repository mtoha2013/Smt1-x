import java.awt.Graphics;

public class MyOval extends java.applet.Applet {
    public void paint(Graphics g) {
        g.drawArc(20,20,60,60,45,180);
        ///g.fillArc(120,20,60,60,90,180);
    }
}