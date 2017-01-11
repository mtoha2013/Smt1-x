/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihan;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author  MToha
 *          201643570041
 */
public class Segi4Round  extends Applet{
    public void paint(Graphics g){
        g.drawRoundRect(20, 20, 60, 60, 10, 30);
        g.draw3DRect(120, 20, 60, 60, true);
    }
}
