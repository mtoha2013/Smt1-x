import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenampilkanImage extends JPanel {

Image image;
Dimension size;

public MenampilkanImage() {
size = new Dimension();
image = new ImageIcon(this.getClass().getResource(“/com/resource/losari-beach.jpg”)).getImage();
size.width = image.getWidth(null);
size.height = image.getHeight(null);
setPreferredSize(size);
}

public void paint(Graphics g) {

Graphics2D g2d = (Graphics2D) g;
//g2d.drawImage(image, 0, 0, null);
g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
}

public static void main(String[] args) {

JFrame frame = new JFrame(“Pantai Losari”);
frame.add(new MenampilkanImage());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}
}