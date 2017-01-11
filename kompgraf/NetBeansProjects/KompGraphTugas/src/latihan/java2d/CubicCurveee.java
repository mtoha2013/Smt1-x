/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihan.java2d;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;

/**
 *
 * @author  MToha
 *          201643570041
 */
public class CubicCurveee extends Applet{
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Shape s = new CubicCurve2D.Double(0, 0, 5, 50, 50, 10, 100, 50);
        g2d.draw(s);
        
        s = new Arc2D.Double(120, 30, 100, 80, 45, 180, Arc2D.PIE);
        g2d.draw(s);
    }
}
