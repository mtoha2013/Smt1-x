import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Jam1 extends Applet implements Runnable
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
    
    void drawHand(double angle, int radius, Graphics g)
    {   
    	angle -= 0.5 * Math.PI;
        int x = (int) (radius*Math.cos(angle));
        int y = (int) (radius*Math.sin(angle));
        g.drawLine(width/2, height/2, width/2 + x, height/2 + y);
    }
    
    void drawWedge(double angle, int radius, Graphics g)
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
        g.drawLine(width/2 + x2, height/2 + y2, width/2 + x, height/2 + y);
        g.drawLine(width/2 + x3, height/2 + y3, width/2 + x, height/2 + y);
        g.drawLine(width/2 + x2, height/2 + y2, width/2 + x3, height/2 + y3);
    }
    
    public void paint(Graphics g)
    {   
    	g.setColor(Color.white);
        drawWedge(2*Math.PI * jam / 12, width/5, g);
        drawWedge(2*Math.PI * menit / 60, width/3, g);
        drawHand(2*Math.PI * detik / 60, width/3, g);
        g.setColor(Color.white);
        g.drawString(strWaktu, 10, height-10);
        for(int i=0;i<12;i++)
        {   
        	int radius = width/2;
            int x = (int) (0.8*radius*Math.cos(i*Math.PI/6-0.5*Math.PI));
            int y = (int) (0.8*radius*Math.sin(i*Math.PI/6-0.5*Math.PI));
            String j = Integer.toString(i);
            if(i==0) j="12";
            g.drawString(j, x+width/2, y+height/2);
        }
    }
}