/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creation;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author  MToha
 *          201643570041
 */
public class AddSubtractEtc extends Applet{
    Area circle;
    Area ellipse;
    
    private void makeShapes(){
        Ellipse2D ellipse1 = new Ellipse2D.Float(30.f, 0f, 60f, 60f);
        circle = new Area(ellipse1);
        Ellipse2D ellipse2 = new Ellipse2D.Float(0f, 20f, 120f, 20f);
        ellipse = new Area(ellipse2);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);
        g2d.drawString("add", 220.0f, 40.0f);
        g2d.drawString("subtract", 210.0f, 110.0f);
        g2d.drawString("intersect", 210.0f, 160.0f);
        g2d.drawString("exclusive or", 205.0f, 240.0f);
        g2d.setColor(Color.blue);
        AffineTransform at = new AffineTransform();
        
        makeShapes();
        circle.add(ellipse);
        at.setToTranslation(80f, 30f);//add ellipse to circle
        g2d.setTransform(at);
        g2d.draw(circle);
        at.setToTranslation(275f, 30f);
        g2d.setTransform(at);
        g2d.fill(circle);
        
        makeShapes();
        circle.subtract(ellipse); //subtract ellipse from circle
        at.setToTranslation(80f, 100f);
        g2d.setTransform(at);
        g2d.draw(circle);
        at.setToTranslation(275f, 100f);
        g2d.setTransform(at);
        g2d.fill(circle);
        
        makeShapes();
        circle.intersect(ellipse); //intersect ellipse from circle
        at.setToTranslation(80f, 165f);
        g2d.setTransform(at);
        g2d.draw(circle);
        at.setToTranslation(275f, 165f);
        g2d.setTransform(at);
        g2d.fill(circle);
        
        makeShapes();
        circle.exclusiveOr(ellipse); //exclusiveOr ellipse from circle
        at.setToTranslation(80f, 230f);
        g2d.setTransform(at);
        g2d.draw(circle);
        at.setToTranslation(275f, 230f);
        g2d.setTransform(at);
        g2d.fill(circle);
    }
}
