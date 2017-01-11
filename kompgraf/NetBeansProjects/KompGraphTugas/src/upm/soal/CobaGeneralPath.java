package upm.soal;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;

public class CobaGeneralPath extends Applet{
    public void paint (Graphics gx){
        Graphics2D g2d = (Graphics2D) gx;
        
        GeneralPath gp1 = new GeneralPath();
        gp1.moveTo(20,20);
        gp1.lineTo(20,50);
        gp1.lineTo(70,50);
        gp1.lineTo(70,20);
        gp1.lineTo(20,20);
        
        GeneralPath gp2 = new GeneralPath();
        gp2.moveTo(80,80);
        gp2.lineTo(80,110);
        gp2.lineTo(130,110);
        gp2.lineTo(130,80);
        gp2.lineTo(80,80);

        BasicStroke bs1 = new BasicStroke(10f);
        g2d.setStroke(bs1);
        g2d.draw(new Line2D.Double(0,0,150,0));
        g2d.draw(new Line2D.Double(0,0,0,150));
        g2d.draw(gp1);
        g2d.draw(gp2);
        
        g2d.translate(180,180);
        g2d.setPaint(Color.blue);
        BasicStroke bs2 = new BasicStroke(2f);
        g2d.setStroke(bs2);
        g2d.draw(new Line2D.Double(0,0,150,0));
        g2d.draw(new Line2D.Double(0,0,0,150));
        g2d.draw(gp1);
        g2d.draw(gp2);
        
        g2d.translate(310,-50);
        g2d.setPaint(Color.green);
        g2d.rotate(Math.PI/3.0);
        BasicStroke bs3 = new BasicStroke(7f);
        g2d.setStroke(bs3);
        g2d.draw(new Line2D.Double(0,0,150,0));
        g2d.draw(new Line2D.Double(0,0,0,150));
        g2d.draw(gp1);
        g2d.draw(gp2);
    }
}