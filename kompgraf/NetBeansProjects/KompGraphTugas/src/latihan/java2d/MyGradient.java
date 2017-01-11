/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.java2d;

import java.applet.Applet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author MToha 201643570041
 */
public class MyGradient extends Applet {

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D e = new Ellipse2D.Float(40, 40, 120, 120);
        GradientPaint gp = new GradientPaint(75, 75, Color.white, 95, 95, Color.gray, true);
        g2.setPaint(gp);
        g2.fill(e);
    }

}
