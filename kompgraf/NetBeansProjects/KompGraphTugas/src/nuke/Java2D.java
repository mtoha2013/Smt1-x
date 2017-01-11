package nuke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.geom.Arc2D;
import javax.swing.*;

/**
 *
 * @author MToha 201643570041
 * Nuke
 */
public class Java2D extends JPanel {

    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 480;
    public static final String TITLE = "...Java 2D...";

    public Java2D() {
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.setColor(Color.red);
        g.drawString("DANGER", 250, 40);

        int xLoc = 250;
        int yLoc = 160;
        
        g.setColor(Color.black);
        g.fillOval(xLoc -7, yLoc - 7, 164, 164);
        
        g.setColor(Color.yellow);
        g.fillOval(xLoc -4, yLoc - 4, 158, 158);
        //Draw Top 
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(60);
        arc.setAngleExtent(60);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.black);
        g2.fill(arc);
        //Draw Left Up
        arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(120);
        arc.setAngleExtent(60);
        g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.yellow);
        g2.fill(arc);
        //Draw Left Bottom
        arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(180);
        arc.setAngleExtent(60);
        g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.black);
        g2.fill(arc);
        //Draw  Bottom
        arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(240);
        arc.setAngleExtent(60);
        g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.yellow);
        g2.fill(arc);
        //Draw Bottom right
        arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(300);
        arc.setAngleExtent(60);
        g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.black);
        g2.fill(arc);
        //Draw Up right
        arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(xLoc, yLoc, 150, 150);
        arc.setAngleStart(360);
        arc.setAngleExtent(60);
        g2 = (Graphics2D) g;
        g2.draw(arc);
        g2.setColor(Color.yellow);
        g2.fill(arc);
        
        g.setColor(Color.yellow);
        int xSmaller = 150 - 110;
        g.fillOval(xLoc +((150-xSmaller)/2), yLoc + ((150-xSmaller)/2), xSmaller, xSmaller);
        
        g.setColor(Color.black);
        int xSmall = 150 - 130;
        g.fillOval(xLoc +((150-xSmall)/2), yLoc + ((150-xSmall)/2), xSmall, xSmall);
        
        g.setColor(Color.RED);
        g.drawString("NUKE", 270, 450);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame(TITLE);
                frame.setContentPane(new Java2D());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}
