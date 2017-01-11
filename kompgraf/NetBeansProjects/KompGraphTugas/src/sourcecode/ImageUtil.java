import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
class ImageUtil
{   public static BufferedImage loadImage(String ref) {
        BufferedImage bimg = null;
        try {   bimg = ImageIO.read(new File(ref));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimg;
    }
}