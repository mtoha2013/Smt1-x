import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class ImageApp2 {     
    public void loadAndDisplayImage(JFrame frame) {   
        // Load the img   
        BufferedImage loadImg = ImageUtil.loadImage("123.jpg");
        frame.setBounds(0, 0, loadImg.getWidth(), loadImg.getHeight());   
        // Set the panel visible and add it to the frame   
           frame.setVisible(true); 
        // Get the surfaces Graphics object   
        Graphics2D g = (Graphics2D)frame.getRootPane().getGraphics();   
        // Now draw the image   
        g.drawImage(loadImg, null, 0, 0);   
       
           
    }    
    public static void main(String[] args) {
        ImageApp2 ia = new ImageApp2();
        JFrame frame = new JFrame("Tutorials");
        ia.loadAndDisplayImage(frame);
    }
}