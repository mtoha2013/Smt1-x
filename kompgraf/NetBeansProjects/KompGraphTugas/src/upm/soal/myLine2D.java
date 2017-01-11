package upm.soal;

import java.awt.*;
import java.applet.*;
import java.awt.geom.*;

public class myLine2D extends Applet {

    public void paint(Graphics g) {
        // menetapkan pola garis (stroke)
        float dashes[] = {10.0f};
        BasicStroke stroke1 = new BasicStroke(5.0f, 1, 2, 1.0f, dashes, 0.0f);
        // memilih objek grafik 2D
        Graphics2D g2d = (Graphics2D) g;
        //Memberi warna hitam sebagai latar belakang
        setBackground(Color.black);
        //Mengubah warna pena menjadi warna hijau
        g2d.setPaint(Color.green);
        //membuat garis yang dikombinasikan dengan pola
        g2d.setStroke(stroke1);
        for (int i = 0; i <= 43; i++) {
            g2d.draw(new Line2D.Double(150, 150, 150 + ((int) 150 * Math.cos(i)), 150 + ((int) 150 * Math
                    .sin(i))));
        }
    }
}
