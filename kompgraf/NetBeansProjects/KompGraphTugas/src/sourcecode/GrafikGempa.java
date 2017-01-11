package sourcecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TampilanGrafikGempa extends Canvas {

    private int jarakTitik;
    private int titikTengah;
    private int jumlahTitik;
    private int[] titik;

    public TampilanGrafikGempa(int jumlahTitik) {
        this.jumlahTitik = jumlahTitik;
        titik = new int[jumlahTitik];

        for (int i = 0; i < jumlahTitik; i++) {
            titik[i] = (int) (Math.random() * 41 - 20);
        }

        setBackground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        jarakTitik = getWidth() / jumlahTitik + 1;
        titikTengah = getHeight() / 2;

        g.setColor(Color.red);
        g.drawLine(0, titikTengah, getWidth(), titikTengah);

        g.setColor(Color.blue);
        for (int i = 1; i < jumlahTitik; i++) {
            g.drawLine((i - 1) * jarakTitik, titikTengah + titik[i - 1], i * jarakTitik, titikTengah + titik[i]);
            titik[i - 1] = titik[i];
        }
        titik[jumlahTitik - 1] = (int) (Math.random() * 250 - 150);
    }
}

class ProsesGrafik extends Thread {

    private TampilanGrafikGempa gambar;

    public ProsesGrafik(TampilanGrafikGempa gambar) {
        this.gambar = gambar;
    }

    @Override
    public void run() {
        while (true) {
            gambar.repaint();
            //agar math random jalan
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}

public class GrafikGempa extends JFrame implements ActionListener {

    private TampilanGrafikGempa gambar = new TampilanGrafikGempa(65);
    private ProsesGrafik proses = new ProsesGrafik(gambar);
    private Button selesai = new Button("Selesai");

    public GrafikGempa() {
        super("Simulasi Grafik Gempa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(100, 100);

        selesai.addActionListener(this);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(gambar, BorderLayout.CENTER);
        getContentPane().add(selesai, BorderLayout.SOUTH);

        show();

        proses.run();
    }

    public static void main(String[] args) {
        new GrafikGempa();
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
