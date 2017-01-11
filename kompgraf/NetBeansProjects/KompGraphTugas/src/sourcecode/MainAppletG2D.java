package sourcecode;

import java.awt.*;
import javax.swing.*;

public class MainAppletG2D extends JApplet {

    private int x;

    public void init() {
        GradientPaintSample z = new GradientPaintSample();
        //TransformSample z = new TransformSample();
        add(z);
    }
}
