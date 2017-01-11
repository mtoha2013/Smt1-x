package usb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class kedua extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(200, 0, 0));
        g2d.fillRect(20, 20, 80, 50);

        g2d.translate(150, 100);
        g2d.rotate(Math.PI);
        g2d.setColor(new Color(200, 0, 0));
        g2d.fillRect(20, 20, 80, 50);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new kedua());
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
