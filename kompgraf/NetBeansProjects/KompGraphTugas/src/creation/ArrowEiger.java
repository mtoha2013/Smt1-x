/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creation;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author  MToha
 *          201643570041
 */
public class ArrowEiger extends Applet{
    private GeneralPath getShape(){
        GeneralPath gpath = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        gpath.moveTo(0.0f, 0.0f);//start point
        gpath.lineTo(-10.0f, 10.0f);//straight line from start
        gpath.lineTo(0.0f, -135.0f);//draw straight line from prev point
        gpath.lineTo(10.0f, 10.0f);//Draw straight line from prev point
        gpath.closePath();//close sub path to last move to
        return gpath;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform at = new AffineTransform();
        at.setToTranslation(250.0, 175.0);
        at.scale(4.0, 4.0);//scale up to 400%
        g2d.setTransform(at);
        GeneralPath gPath = getShape();
        g2d.draw(gPath);//draw outline of shape in black <default>
        g2d.setColor(Color.cyan);//change colour
        g2d.fill(gPath);
    }

}
