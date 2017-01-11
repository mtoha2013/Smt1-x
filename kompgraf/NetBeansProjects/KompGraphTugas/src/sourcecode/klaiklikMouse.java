package sourcecode;


/* Anda dapt menciptakan sebuah area yang user dapat meng-klik tanpa menggunakan button.
 * Aksi dimana didalam sebuah tampilan dengan Applet bisa di-klik, maka ini situasi dimana 
 * fungsi MouseListener digunakan.
 * Kita akan memmbuat sebuah applet yang akan menunjukkan aksi ketika user meng-klik
 * didalam area atau diluar area objek atau pun applet.
 */
import java.awt.*;
import java.applet.*;
// Meng-import class Extra untuk MouseListener
import java.awt.event.*;

public class klaiklikMouse extends Applet implements MouseListener {

    // Kordinat X dan Y pada saat di klik
    int xpos;
    int ypos;

    // Kooedinat dari sebuah Rectangle akan dibuat
    // dan  menerangkan wilayah yang masuk didalam area Applet
    int rect1xco, rect1yco, rect1width, rect1height;

    // Variabel yang menjelaskan aksi dari/saat mouse meng-klik
    boolean mouseEntered;

    // variabel yang menjelaskan ketika mouse meng-klik didalam area Rectangle
    boolean rect1Clicked;

    public void init() {
        // Value yang akan digunakan dalm membentuk cooedinat pada Rectangle
        rect1xco = 20;
        rect1yco = 20;
        rect1width = 100;
        rect1height = 50;

        // memeasukkan aksi MouseListener pada Applet
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        // Warna Rectangle
        g.setColor(Color.blue);
        g.fillRect(rect1xco, rect1yco, rect1width, rect1height);
        g.setColor(Color.green);

        // infromasi tentang posisi didalam area yang di-klik.
        g.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);

        // Informasi yang akan ditampilkan ketika meng-klik didalam area Rectangle
        if (rect1Clicked) {
            g.drawString("Anda Berada Didalam Area Rectangle", 20, 120);
        } else {
            g.drawString("Anda Berada Diluar Area Rectangle", 20, 120);
        }

        if (mouseEntered) {
            g.drawString("Anda Didalam Area Applet", 20, 160);
        } else {
            g.drawString("Anda Berada Diluar Applet", 20, 160);
        }
    }

    /* Ini adalah beberapa Methods yang dipakai ketika menggunakan MouseListener

     public void mouseClicked (MouseEvent me) {}
     public void mouseEntered (MouseEvent me) {}
     public void mousePressed (MouseEvent me) {}
     public void mouseReleased (MouseEvent me) {}	
     public void mouseExited (MouseEvent me) {}	
     */
    // Methods yang akan digunakan ketika mouse neg-klik
    public void mouseClicked(MouseEvent me) {

        // Menyimpan posisi mouse saat meng-klik
        xpos = me.getX();
        ypos = me.getY();

        // memrikasa apakah mouse berada didalam area atau tidak
        if (xpos > rect1xco && xpos < rect1xco + rect1width && ypos > rect1yco && ypos < rect1yco + rect1height) {
            rect1Clicked = true;
        } // kalau tidak dalam area maka bernilai salah;
        else {
            rect1Clicked = false;
        }
        //menampilkan kembali hasil klik
        repaint();

    }

    // proses ketika mouse ditekan
    public void mousePressed(MouseEvent me) {
    }

    // proses apakah terjadi atau tidak sat mouse di tekan atau dilepas
    public void mouseReleased(MouseEvent me) {
    }

    // proses yang akan terjadi pada saat mouse memasuki area applet.
    // dan akan dieksekusi kembali ketika mouse meninggalkan area.
    public void mouseEntered(MouseEvent me) {
        // aksi yang akan mencoba memberitahukan mouse memasuki area didalam Applet
        mouseEntered = true;
        repaint();
    }

    // ketika mouse meninggalkan Applet
    public void mouseExited(MouseEvent me) {
        // aksi yang akan mencoba memberitahukan mouse meninggalkan area didalam Applet
        mouseEntered = false;
        repaint();
    }

    /* Dengan ini anda dapat menggunakan MouseListener selain yang biasanya sering digunakan untuk mengoperasikan button
     * So now you can use the MouseListener instead of Buttons. 
     */
}
