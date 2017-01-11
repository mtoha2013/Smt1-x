package sourcecode;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class MainMenu extends JFrame implements ItemListener {   //private JDesktopPane dp1 = new JDesktopPane();

    private JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT)),
            p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)),
            p3 = new JPanel();
    private String[] items = {"Gradient Paint Sample", "Transform Sample", "Clear"};
    private JComboBox cb1 = new JComboBox(items);
    private Date tgl = new Date();
    private SimpleDateFormat frmtTgl = new SimpleDateFormat("dd MMMM yyyy",
            Locale.getDefault());
    private String tgl1 = frmtTgl.format(tgl);
    private JLabel lblTgl = new JLabel(tgl1),
            lblJam = new JLabel();
    private JToolBar tb1 = new JToolBar();
    private int pjg = Toolkit.getDefaultToolkit().getScreenSize().width,
            tgi = Toolkit.getDefaultToolkit().getScreenSize().height;
    private TransformSample sg = new TransformSample();
    private GradientPaintSample pp = new GradientPaintSample();

    public MainMenu() {
        super("Main Menu");
        setSize(400, 500);
        setLocation((pjg - getWidth()) / 2, (tgi - getHeight()) / 2);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            }
        });
        cb1.addItemListener(this);
        p1.add(cb1);
        lblJam.setForeground(Color.red);
        lblJam.setFont(new Font("Tahoma", Font.BOLD, 30));
        p2.add(lblJam);
        tb1.add(p1);
        tb1.add(p2);
        p3.setLayout(new BorderLayout());
        p3.setFont(new Font("Tahoma", Font.BOLD, 10));
        p3.add(lblTgl, BorderLayout.WEST);
        //dp1.setBackground(Color.gray);
        getContentPane().add(tb1, BorderLayout.NORTH);
        //getContentPane().add(dp1, BorderLayout.CENTER);
        getContentPane().add(p3, BorderLayout.SOUTH);
        setJam();
    }

    public void setJam() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";
                Date dateTime = new Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                lblJam.setText(jam + ":" + menit + ":" + detik + " ");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) e.getItem();
            if (item.equals("Gradient Paint Sample")) {
                getContentPane().add(pp, BorderLayout.CENTER);
                pp.setBackground(Color.black);
                sg.setVisible(false);
                pp.setVisible(true);
            }
            if (item.equals("Transform Sample")) {
                getContentPane().add(sg, BorderLayout.CENTER);
                sg.setBackground(Color.black);
                pp.setVisible(false);
                sg.setVisible(true);
            }
            if (item.equals("Clear")) {
                sg.setVisible(false);
                pp.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu().show();
    }
}
