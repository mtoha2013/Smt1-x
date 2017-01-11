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
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author MToha 201643570041
 */
public class Subtract extends Applet {

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        //lingkaran pertama
        Shape s1 = new Ellipse2D.Double(0, 0, 100, 100);
        //lingkaran kedua
        Shape s2 = new Ellipse2D.Double(60, 0, 100, 100);
        //area geometri pertama
        Area a2 = new Area(s2);
        //pindah posisi kedua kedua lingkaran dengan x=20 y=50
        g2.translate(20, 50);
        //gambar lingkaran pertama
        g2.draw(s1);
        //gambar lingkaran kedua
        g2.draw(s2);
        //area geometri kedua
        Area a1 = new Area(s1);
        //operasi “subtract”
        a1.subtract(a2);
        //penentuan ketebalan dan warna garis
        BasicStroke bsThickLine = new BasicStroke(5.0f);
        g2.setStroke(bsThickLine);
        g2.setPaint(Color.blue);

        //gambar bidang hasil operasi “subtract”
        g2.draw(a1);
        //penentuan warna untuk mengisi bidang hasil operasi “subtract”.
        g2.setPaint(Color.green);
        //pewarnaan bidang hasil operasi “subtract”.
        g2.fill(a1);
    }

}
