package sourcecode;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class CompPanel extends Applet {

    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC);
    float alpha = 1.0f;

    public CompPanel() {
    }

// Resets the alpha and composite rules with selected items.	
    public void changeRule(String a, int rule) {
        alpha = Float.valueOf(a).floatValue();
        ac = AlphaComposite.getInstance(getRule(rule), alpha);
        repaint();
    }

// Gets the requested compositing rule.
    public int getRule(int rule) {
        int alphaComp = 0;
        switch (rule) {
            case 0:
                alphaComp = AlphaComposite.SRC;
                break;
            case 1:
                alphaComp = AlphaComposite.DST_IN;
                break;
            case 2:
                alphaComp = AlphaComposite.DST_OUT;
                break;
            case 3:
                alphaComp = AlphaComposite.DST_OVER;
                break;
            case 4:
                alphaComp = AlphaComposite.SRC_IN;
                break;
            case 5:
                alphaComp = AlphaComposite.SRC_OVER;
                break;
            case 6:
                alphaComp = AlphaComposite.SRC_OUT;
                break;
            case 7:
                alphaComp = AlphaComposite.CLEAR;
                break;
        }
        return alphaComp;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        Dimension d = getSize();
        int w = d.width;
        int h = d.height;

        // Creates the buffered image.
        BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = buffImg.createGraphics();

        // Clears the previously drawn image.
        g2.setColor(Color.white);
        g2.fillRect(0, 0, d.width, d.height);

        int rectx = w / 4;
        int recty = h / 4;

        // Draws the rectangle and ellipse into the buffered image.
        gbi.setColor(new Color(0.0f, 0.0f, 1.0f, 1.0f));
        gbi.fill(new Rectangle2D.Double(rectx, recty, 150, 100));
        gbi.setColor(new Color(1.0f, 0.0f, 0.0f, 1.0f));
        gbi.setComposite(ac);
        gbi.fill(new Ellipse2D.Double(rectx + rectx / 2, recty + recty / 2, 150, 100));

        // Draws the buffered image.
        g2.drawImage(buffImg, null, 0, 0);
    }
}
