/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.java2d;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author MToha 201643570041
 */
public class SetStroke extends Applet {

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                new float[]{3, 1}, 0);
        g2.setStroke(stroke);
        g2.setPaint(Color.black);
        float cm = 72 / 2.54f;
        Shape shape = new Rectangle2D.Float(cm, cm, 2 * cm, cm);
        g2.draw(shape);
    }

}
