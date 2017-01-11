package sourcecode;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrameG2D {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Sekarang pake Label");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GradientPaintSample t = new GradientPaintSample();
                //TransformSample t = new TransformSample();
                t.setPreferredSize(new Dimension(400, 400));
                frame.getContentPane().add(t);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
