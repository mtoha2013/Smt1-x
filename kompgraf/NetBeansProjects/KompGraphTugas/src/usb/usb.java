package usb;

import java.awt.*;
import java.awt.Font;

public class usb extends java.applet.Applet {

    @Override
    public void paint(Graphics u) {
        u.setColor(Color.magenta);
        u.fillArc(100, 100, 80, 100, 90, 180);
        u.setColor(Color.black);
        u.fillRect(150, 125, 40, 50);
        u.setColor(Color.magenta);
        u.fillRect(180, 100, 180, 100);
        u.setColor(Color.magenta);
        u.fillArc(320, 100, 80, 100, -90, 180);
        u.setColor(Color.white);
        u.fillRect(160, 130, 10, 10);
        u.setColor(Color.white);
        u.fillRect(160, 160, 10, 10);
        u.setColor(Color.yellow);
        u.fillOval(320, 125, 50, 50);
        u.setColor(Color.white);
        Font f = new Font("harrington", Font.ITALIC, 12);
        u.setFont(f);
        u.drawString("kingston", 190, 180);

        u.setColor(Color.green);
        Font g = new Font("harrington", Font.BOLD, 24);
        u.setFont(g);
        u.drawString("USB Unindra", 200, 250);

    }
}
