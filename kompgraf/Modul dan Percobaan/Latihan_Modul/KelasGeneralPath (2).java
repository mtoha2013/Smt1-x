import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.*;
import java.awt.geom.*;
public class KelasGeneralPath extends JApplet {
    public static void main(String s[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Kelas GeneraPath");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new KelasGeneralPath();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);}
    public void init() {
        JPanel panel = new Panel2D();
        getContentPane().add(panel);
    }}
class Panel2D extends JPanel{
    public Panel2D() {
                setPreferredSize(new Dimension(500, 400));
                setBackground(Color.white);
            }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        GeneralPath gp = new GeneralPath();
//Mulai dari sudut depan-bawah mobil.
    gp.moveTo(60,120);
//bagian bodi bawah-depan
    gp.lineTo(80,120);
//roda depan
    gp.quadTo(90,140,100,120);
//bagian bodi bawah-tengah
    gp.lineTo(160,120);
//roda belakang
    gp.quadTo(170,140,180,120);
//bagian bodi bawah-belakang
gp.lineTo(200,120);
//bagian belakang mobil
gp.curveTo(195,100,200,80,160,80);
//atap
gp.lineTo(110,80);
//kaca depan
gp.lineTo(90,100);
//bagian hidung mobil
gp.lineTo(60,100);
//bagian depan mobil
gp.lineTo(60,120);
//menggambar mobil
g2.draw(gp);

}}


