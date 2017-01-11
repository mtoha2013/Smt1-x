/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.java2d;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author MToha 201643570041
 */
public class MyGeneralPath extends Applet {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();
        //Mulai dari sudut depan-bawah mobil.
        gp.moveTo(60, 120);
        //bagian bodi bawah-depan
        gp.lineTo(80, 120);
        //roda depan
        gp.quadTo(90, 140, 100, 120);
        //bagian bodi bawah-tengah
        gp.lineTo(160, 120);
        //roda belakang
        gp.quadTo(170, 140, 180, 120);
        //bagian bodi bawah-belakang
        gp.lineTo(200, 120);
        //bagian belakang mobil
        gp.curveTo(195, 100, 200, 80, 160, 80);
        //atap
        gp.lineTo(110, 80);
        //kaca depan
        gp.lineTo(90, 100);
        //bagian hidung mobil
        gp.lineTo(60, 100);
        //bagian depan mobil
        gp.lineTo(60, 120);
        //menggambar mobil
        g2.draw(gp);
    }
}
