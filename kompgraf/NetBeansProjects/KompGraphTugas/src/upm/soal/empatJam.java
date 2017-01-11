package upm.soal;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class empatJam extends Applet implements Runnable
{   
	int width, height;
    Thread t = null;
    boolean threadSuspended;
    int jam=0, menit=0, detik=0;
    String strWaktu = "";
    
    public void init()
    {   
    	width = getSize().width;
        height = getSize().height;
        setBackground(Color.black);
    }
    
    public void start()
    {   
    	if(t == null)
        {   
        	t = new Thread(this);
            t.setPriority(Thread.MIN_PRIORITY);
            threadSuspended = false;
            t.start();
        } 
        else
        {   
        	if(threadSuspended)
            {   
            	threadSuspended=false;
                synchronized(this)
                {   
                	notify();
                }
            }
        }
    }
    
    public void stop()
    {   
    	threadSuspended = true;
    }
    
    public void run()
    {   
    	try
        {   
        	while(true)
            {   
            	Calendar cal = Calendar.getInstance();
                jam = cal.get(Calendar.HOUR_OF_DAY);
                if(jam > 12) jam -= 12;
                menit = cal.get(Calendar.MINUTE);
                detik = cal.get(Calendar.SECOND);
                
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
                Date tgl = cal.getTime();
                strWaktu = sdf.format(tgl);
                
                if(threadSuspended)
                {   
                	synchronized(this)
                    {   
                    	while(threadSuspended)
                        {   
                        	wait();
                        }
                    }
                }
                repaint();
                //Color[] c = {Color.red, Color.green, Color.yellow, Color.black};
                //int[] x = {6, 12, 15};
                //setBackground(c[detik%4]);
                t.sleep(1000);
            }
        } 
        catch(InterruptedException e)
        {
        }
    }
    void drawHand(int posX, int posY, double angle, int radius, Graphics g)
    {   
    	angle -= 0.5 * Math.PI;
        int x = (int) (radius*Math.cos(angle));
        int y = (int) (radius*Math.sin(angle));
        g.drawLine(posX, posY, posX+x, posY+ y);
    }
    
    void drawWedge(int posX, int posY, double angle, int radius, Graphics g)
    {   
    	angle -= 0.5 * Math.PI;
        int x = (int) (radius*Math.cos(angle));
        int y = (int) (radius*Math.sin(angle));
        angle += 2*Math.PI/3;
        int x2 = (int) (5*Math.cos(angle));
        int y2 = (int) (5*Math.sin(angle));
        angle += 2*Math.PI/3;
        int x3 = (int) (5*Math.cos(angle));
        int y3 = (int) (5*Math.sin(angle));
        g.drawLine(posX+ x2, posY+ y2, posX+ x, posY + y);
        g.drawLine(posX+ x3, posY + y3, posX+ x, posY + y);
        g.drawLine(posX+ x2,posY + y2, posX+ x3, posY + y3);
    }
    void drawRoundedNum(int posX, int posY, int radius, Graphics g)
    {	for(int i=0;i<12;i++)
        {
        	int x = (int) (0.8*radius*Math.cos(i*Math.PI/6-0.5*Math.PI));
            int y = (int) (0.8*radius*Math.sin(i*Math.PI/6-0.5*Math.PI));
            String j = Integer.toString(i);
            if(i==0) j="12";
            for(int k=0;k<width;k+=width/4)
                if(k%2==0) g.drawString(j, x+posX, y+posY);
        }
    }
    
    public void paint(Graphics g)
    {   
    	g.setColor(Color.white);
        int z=0;
        for(int i=0;i<width;i+=width/4)
            if(i%2==1)
            {   
            	drawWedge(i,height/4,2*Math.PI * (jam-z) / 12, width/12, g);
                drawWedge(i,height/4,2*Math.PI * (menit) / 60, width/8, g);
                drawWedge(i,height-height/4,2*Math.PI * (jam-z-5) / 12, width/12, g);
                drawWedge(i,height-height/4,2*Math.PI * (menit) / 60, width/8, g);
                drawHand(i,height/4,2*Math.PI * (detik) / 60, width/8, g);
                drawHand(i,height-height/4,2*Math.PI * (detik) / 60, width/8, g);
                drawRoundedNum(i,height/4, width/4, g);
                drawRoundedNum(i,height-height/4, width/4, g);
                z+=7;
            }
        g.setColor(Color.white);
        g.drawString(strWaktu, 10, height-10);
    }
}