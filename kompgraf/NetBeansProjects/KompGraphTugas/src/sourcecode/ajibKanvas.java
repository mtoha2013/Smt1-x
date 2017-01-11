package sourcecode;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ajibKanvas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Sekarang pake Label");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ajibStar t = new ajibStar();
                t.setPreferredSize(new Dimension(600, 600));
                frame.getContentPane().add(t);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
