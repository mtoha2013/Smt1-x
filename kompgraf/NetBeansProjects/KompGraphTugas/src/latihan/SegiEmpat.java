package latihan;

import java.awt.Graphics;

public class SegiEmpat extends java.applet.Applet {

    public void paint(Graphics g) {
        g.drawRoundRect(20, 20, 60, 60, 10, 10);
        g.fillRoundRect(120, 20, 60, 60, 20, 20);
    }
}