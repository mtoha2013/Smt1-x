import java.awt.*;  
import java.awt.event.*; 
import javax.swing.*;  

public class ImageZoomer extends JApplet implements ActionListener 
{  
    //static variables 
    public static final double DEFAULT_ZOOM_PERCENTAGE = 10.00;         
    public static final String ZOOM_CURSOR = "zoom_cursor.gif"; 
          
    //public variables 
    private String images[] = {"123.jpg",
                               "buriek.jpg", 
                               "a7x1.jpg", 
                               "cute-tree.jpg",
                               "gw.jpg",
                               "skull.jpg",
                               "so.jpg"};  
     
    private JButton m_launch; 
    private JList m_imageList; 
    private JTextField m_zoomPercentage; 

    public void init()  
    {  
        getContentPane().setLayout(new BorderLayout()); 
         
        m_imageList = new JList(images); 
        m_imageList.setSelectedIndex(0); 
                 
        m_launch = new JButton("Launch Image Zoomer"); 
        m_launch.addActionListener(this);             
         
        Panel input = new Panel(new FlowLayout()); 
        input.add(m_launch); 
         
        Panel input1 = new Panel(new FlowLayout()); 
        input1.add(new Label("Enter zoom percentage: ")); 
         
        m_zoomPercentage = new JTextField(5); 
        m_zoomPercentage.setText("10"); 
         
        input1.add(m_zoomPercentage); 
          
        getContentPane().add(BorderLayout.NORTH, input1);  
        getContentPane().add(BorderLayout.CENTER, m_imageList); 
        getContentPane().add(BorderLayout.SOUTH, input); 
    }  

    public void actionPerformed(ActionEvent ae) 
    { 
        if(ae.getSource().equals(m_launch)) 
        { 
            //getting the image 
            String imageName = ((String)(m_imageList.getSelectedValue())).trim(); 
            Image image = getImage(getCodeBase(), imageName); 
            Image zoomcursorImage = getImage(getCodeBase(), ZOOM_CURSOR); 
             
            MediaTracker mt = new MediaTracker(this); 
            mt.addImage(image, 1); 
            mt.addImage(zoomcursorImage, 2); 
             
            try  
            {  
                mt.waitForAll();  
            }  
            catch (InterruptedException e)  
            {  
                e.printStackTrace();  
            } 
              
            double per = DEFAULT_ZOOM_PERCENTAGE; 
             
            try 
            { 
                per = Double.valueOf(m_zoomPercentage.getText().trim()).intValue(); 
            } 
            catch(NumberFormatException numExp) 
            { 
            }                 
             
            //create the Image Zoomer frame 
            ImageZoomerFrame imageZoomer = new ImageZoomerFrame(image, per, imageName); 
             
            //set the zoom cursor image 
            imageZoomer.setZoomCursorImage(zoomcursorImage); 
        }     
    }         
}  