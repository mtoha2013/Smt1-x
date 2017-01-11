import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;

public class PiringTerbang extends JFrame
{
 public PiringTerbang()
 {
  super("Contoh Membuat Piring Terbang");
  setSize(500,300);
  setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }
 
 public void paint(Graphics comp)
 {
  Graphics2D g2d = (Graphics2D) comp;
  
  //--- Buat Bintang
  Random acak = new Random();
  for (int i=0; i<1000; i++)
  {
   double x = acak.nextInt(600);
   double y = acak.nextInt(220);
   
   Line2D.Double sisi_bintang1 = new Line2D.Double (x-1, y-1, x+1, y+1);
   Line2D.Double sisi_bintang2 = new Line2D.Double (x-1, y+1, x+1, y-1);
   g2d.draw(sisi_bintang1);
   g2d.draw(sisi_bintang1);
  }
  
  //--- Buat UFO
  Ellipse2D.Double ufo = new Ellipse2D.Double(250, 50, 100, 25);
  Line2D.Double antena = new Line2D.Double (300, 50, 300, 35);
  
  g2d.setPaint(Color.black);
  g2d.fill(ufo);
  g2d.draw(ufo);
  g2d.draw(antena);
  
  //--- Buat Garis Mendatar
  Line2D.Double horison = new Line2D.Double(20, 245, 480, 245);
  g2d.draw(horison);
  
  //--- Buat Mobil
  GeneralPath gp = new GeneralPath();
  
  gp.moveTo(100, 255); // ke ujung kiri bawah
  gp.lineTo(100, 240);
  gp.lineTo(120, 235);
  gp.lineTo(130, 220);
  gp.lineTo(190, 220);
  gp.curveTo(200, 230, 210, 240, 210,255);
  gp.lineTo(195, 255);
  gp.quadTo(185, 275, 175, 255);// Roda Kanan
  gp.lineTo(135, 255);
  gp.quadTo(125, 275, 115, 255);//Roda Kiri
  gp.lineTo(100,255);
  
  g2d.setPaint(Color.red);
  g2d.fill(gp);
  g2d.draw(gp);
 }
 
 public static void main (String [] args)
 {
  PiringTerbang app = new PiringTerbang();
 }
}