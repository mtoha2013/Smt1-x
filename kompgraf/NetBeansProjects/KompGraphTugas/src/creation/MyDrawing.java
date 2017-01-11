/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

/**
 *
 * @author MToha 201643570041
 */
public class MyDrawing extends Applet {
    
    private double p[] = {0.0, 0.0, -10.0, 10.0, 0.0, -15.0, 10.0, 10.0, 0.0, 0.0};
    
    @Override
    public void paint(Graphics g) {
        double pa[] = new double[10];
        AffineTransform at = new AffineTransform();
        at.setToTranslation(0.0, 175.0);
        at.rotate(Math.PI / 2.0);
        at.transform(p, 0, pa, 0, 5);
        at.setToRotation(-(Math.PI / 16.0));
        for (int x = 0; x < 10; x++) {
            for (int i = 3; i < 10; i += 2) {
                g.drawLine((int) pa[i - 3], (int) pa[i - 2], (int) pa[i - 1], (int) pa[i]);
            }
            at.transform(pa, 0, pa, 0, 5);
        }
    }
    
}
