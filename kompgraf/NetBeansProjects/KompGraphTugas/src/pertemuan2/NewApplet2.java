/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan2;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author USER
 */
public class NewApplet2 extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
    @Override
    public void paint(Graphics g) {       
        super.paint(g); 
        g.fill3DRect(30, 20, 15, 25, true);
        g.fill3DRect(90, 20, 15, 25, true);
        //g.fillArc(100, 100, 150, 150, 310,100);
        //g.drawRoundRect(20, 20, 60, 60, 5, 50);
    }

    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    // TODO overwrite start(), stop() and destroy() methods
}

