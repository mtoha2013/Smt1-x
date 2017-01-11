package sourcecode;

import java.awt.*;

public class circle_right extends java.applet.Applet {

    private int mouseX, mouseY;
    private boolean mouseClicked = false;

    public void init() {
        setBackground(Color.magenta);
    }

    public boolean mouseDown(Event e, int x, int y) {
        mouseX = x;
        mouseY = y;
        mouseClicked = true;
        repaint();
        return true;
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        if (mouseClicked) {
            g.fillOval((mouseX), (mouseY), 50, 50);
            mouseClicked = false;
        }
    }

    public void update(Graphics g) {
        paint(g);
    }
}
