/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author MToha 201643570041
 * Dadu
 */
public class Dadu extends Applet{

    @Override
    public void paint(Graphics g) {
        g.drawString("Dadu", 100, 20);
        g.drawRect(20, 30, 200  ,200);
        g.drawLine(120,30,120,30+200);
        g.drawLine(20,(230/2),(220),(230/2));
        g.fillOval(40, 40, 70, 70);
        
        g.fillOval(40, 140, 70, 70);
        
        g.fillOval(135, 140, 70, 70);
        g.fillOval(135, 40, 70, 70);
    }
    
}
