package sourcecode;

import java.awt.*;

public class circle extends java.applet.Applet {

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
            g.fillOval((mouseX - 5), (mouseY - 5), 10, 10);
            mouseClicked = false;
        }
    }
}
