package latihan;

import java.awt.Graphics;

public class OvalOk extends java.applet.Applet {

    public void paint(Graphics g) {
        g.drawOval(20, 20, 60, 60);
        g.fillOval(120, 20, 100, 60);
    }
}