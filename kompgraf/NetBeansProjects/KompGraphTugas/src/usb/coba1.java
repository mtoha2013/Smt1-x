package usb;

import java.awt.*;
import javax.swing.JApplet;

public class coba1 extends JApplet {

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillArc(70, 80, 60, 60, 90, 180);
        g.setColor(Color.red);
        g.drawRect(110, 95, 20, 30);
        g.setColor(Color.blue);
        g.drawLine(130, 80, 130, 140);
        g.setColor(Color.blue);
        g.drawArc(200, 80, 60, 60, 90, -180);
    }
}
