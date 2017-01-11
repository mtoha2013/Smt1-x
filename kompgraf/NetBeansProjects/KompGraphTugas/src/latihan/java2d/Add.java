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
public class Add extends Applet {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape s1 = new Ellipse2D.Double(0, 0, 100, 100);
        //lingkaran kedua.
        Shape s2 = new Ellipse2D.Double(60, 0, 100, 100);
        //area geometri pertama.
        Area a1 = new Area(s1);
        //area geometri kedua.
        Area a2 = new Area(s2);
        //geser posisi kedua kedua lingkaran dengan x=20 y=50.
        g2.translate(20, 50);
        //penentuan ketebalan dan warna garis.
        BasicStroke bsThickLine = new BasicStroke(5.0f);
        g2.setStroke(bsThickLine);
        g2.setPaint(Color.blue);
        //gambar lingkaran pertama.
        g2.draw(s1);
//gambar lingkaran kedua.
        g2.draw(s2);
        //operasi “add”.
        //        11
        a2.add(a1);
        //penentuan warna untuk mengisi hasil operasi “add”.
        g2.setPaint(Color.green);
        //pewarnaan area hasil operasi “add”.
        g2.fill(a2);
    }
}
