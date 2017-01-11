import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class ImageZoomerFrame extends JFrame  
       implements MouseListener, ActionListener 
{ 
    private ImagePanel m_imagePanel; 
    private JScrollPane m_srollPane; 
    private JPanel m_imageContainer; 
    private JLabel m_zoomedInfo; 
    private JButton m_zoomInButton; 
    private JButton m_zoomOutButton; 
    private JButton m_originalButton; 
    private Cursor m_zoomCursor; 

    public ImageZoomerFrame(Image image, double zoomPercentage, String imageName) 
    { 
        super("Image Zoomer [" + imageName + "]"); 
         
        if(image == null) 
        { 
            add(new JLabel("Image " + imageName + " not Found")); 
        } 
        else 
        { 
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
            m_zoomInButton = new JButton("Zoom In"); 
            m_zoomInButton.addActionListener(this); 
             
            m_zoomOutButton = new JButton("Zoom Out"); 
            m_zoomOutButton.addActionListener(this); 
             
            m_originalButton = new JButton("Original"); 
            m_originalButton.addActionListener(this); 
             
            m_zoomedInfo = new JLabel("Zoomed to 100%"); 
             
            topPanel.add(new JLabel("Zoom Percentage is " +  
                                    (int)zoomPercentage + "%")); 
            topPanel.add(m_zoomInButton); 
            topPanel.add(m_originalButton); 
            topPanel.add(m_zoomOutButton); 
            topPanel.add(m_zoomedInfo); 
                                     
            m_imagePanel = new ImagePanel(image, zoomPercentage); 
            m_imagePanel.addMouseListener(this); 
             
            m_imageContainer = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
            m_imageContainer.setBackground(Color.BLACK); 
            m_imageContainer.add(m_imagePanel); 
             
            m_srollPane = new JScrollPane(m_imageContainer); 
            m_srollPane.setAutoscrolls(true); 
             
            getContentPane().add(BorderLayout.NORTH, topPanel); 
            getContentPane().add(BorderLayout.CENTER, m_srollPane); 
            getContentPane().add(BorderLayout.SOUTH,  
                         new JLabel("Left Click to Zoom In," + 
                         " Right Click to Zoom Out", JLabel.CENTER)); 
             
            m_imagePanel.repaint(); 
        } 
         
        pack(); 
        setVisible(true); 
    } 
     
    public void actionPerformed(ActionEvent ae) 
    { 
        if(ae.getSource().equals(m_zoomInButton)) 
        { 
            m_imagePanel.zoomIn(); 
            adjustLayout(); 
        } 
        else if(ae.getSource().equals(m_zoomOutButton)) 
        { 
            m_imagePanel.zoomOut(); 
            adjustLayout(); 
        } 
        else if(ae.getSource().equals(m_originalButton)) 
        { 
            m_imagePanel.originalSize(); 
            adjustLayout(); 
        } 
    } 

    public void setZoomCursorImage(Image zoomcursorImage) 
    { 
        m_zoomCursor = Toolkit.getDefaultToolkit().createCustomCursor( 
                        zoomcursorImage, new Point(0, 0), "ZoomCursor"); 
    } 

    private void adjustLayout() 
    { 
        m_imageContainer.doLayout();         
        m_srollPane.doLayout(); 

        m_zoomedInfo.setText("Zoomed to " + (int)m_imagePanel.getZoomedTo() + "%"); 
    } 

    public void mouseClicked(MouseEvent e)  
    { 
        if(e.getButton() == MouseEvent.BUTTON1) 
        { 
            m_imagePanel.zoomIn();                  
        } 
        else if(e.getButton() == MouseEvent.BUTTON3) 
        { 
            m_imagePanel.zoomOut(); 
        } 

        adjustLayout(); 
    } 
         
    public void mouseEntered(MouseEvent e) 
    { 
        m_imageContainer.setCursor(m_zoomCursor);              
    } 
            
    public void mouseExited(MouseEvent e) 
    { 
        m_imageContainer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));          
    } 
            
    public void mousePressed(MouseEvent e) 
    { 
      
    } 
            
    public void mouseReleased(MouseEvent e) 
    { 
      
    } 

    public class ImagePanel extends JPanel 
    { 
        private double m_zoom = 1.0; 
        private double m_zoomPercentage; 
        private Image m_image; 
             
        public ImagePanel(Image image, double zoomPercentage) 
        { 
            m_image = image; 
            m_zoomPercentage = zoomPercentage / 100; 
        } 

        public void paintComponent(Graphics grp)  
        {  
            Graphics2D g2D = (Graphics2D)grp; 
             
            //set the background color to white 
            g2D.setColor(Color.WHITE); 
            //fill the rect 
            g2D.fillRect(0, 0, getWidth(), getHeight()); 
             
            //scale the graphics to get the zoom effect 
            g2D.scale(m_zoom, m_zoom); 
             
            //draw the image 
            g2D.drawImage(m_image, 0, 0, this);  
        } 

        public Dimension getPreferredSize() 
        { 
            return new Dimension((int)(m_image.getWidth(this) +  
                                      (m_image.getWidth(this) * (m_zoom - 1))), 
                                 (int)(m_image.getHeight(this) +  
                                      (m_image.getHeight(this) * (m_zoom -1 )))); 
        } 

        public void setZoomPercentage(int zoomPercentage) 
        { 
            m_zoomPercentage = ((double)zoomPercentage) / 100;     
        } 

        public void originalSize() 
        { 
            m_zoom = 1;  
        } 

        public void zoomIn() 
        { 
            m_zoom += m_zoomPercentage; 
        }             
        
        //Proses pengecilan image
        public void zoomOut() 
        { 
            m_zoom -= m_zoomPercentage; 
             
            if(m_zoom < m_zoomPercentage) 
            { 
                if(m_zoomPercentage > 1.0) 
                { 
                    m_zoom = 1.0; 
                } 
                else 
                { 
                    zoomIn(); 
                } 
            } 
        } 

        public double getZoomedTo() 
        { 
            return m_zoom * 100;  
        } 
    } 
} 