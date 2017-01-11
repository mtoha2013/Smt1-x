package sourcecode;

import java.lang.Integer;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class Composite extends JApplet implements ItemListener {

    CompPanel comp;
    JLabel alphaLabel, rulesLabel;
    JComboBox alphas, rules;
    String alpha = "1.0";
    int rule = 0;

    // Initializes the layout of the components.
    public void init() {
        GridBagLayout layOut = new GridBagLayout();
        getContentPane().setLayout(layOut);

        GridBagConstraints l = new GridBagConstraints();
        l.weightx = 1.0;
        l.fill = GridBagConstraints.BOTH;
        l.gridwidth = GridBagConstraints.RELATIVE;
        alphaLabel = new JLabel();
        alphaLabel.setText("Alphas");
        Font newFont = getFont().deriveFont(1);
        alphaLabel.setFont(newFont);
        alphaLabel.setHorizontalAlignment(JLabel.CENTER);
        layOut.setConstraints(alphaLabel, l);
        getContentPane().add(alphaLabel);
        GridBagConstraints c = new GridBagConstraints();
        getContentPane().setLayout(layOut);

        l.gridwidth = GridBagConstraints.REMAINDER;
        rulesLabel = new JLabel();
        rulesLabel.setText("Rules");
        newFont = getFont().deriveFont(1);
        rulesLabel.setFont(newFont);
        rulesLabel.setHorizontalAlignment(JLabel.CENTER);
        layOut.setConstraints(rulesLabel, l);
        getContentPane().add(rulesLabel);

        GridBagConstraints a = new GridBagConstraints();
        a.gridwidth = GridBagConstraints.RELATIVE;
        a.weightx = 1.0;
        a.fill = GridBagConstraints.BOTH;
        alphas = new JComboBox();
        layOut.setConstraints(alphas, a);
        alphas.addItem("1.0");
        alphas.addItem("0.75");
        alphas.addItem("0.50");
        alphas.addItem("0.25");
        alphas.addItem("0.0");
        alphas.addItemListener(this);
        getContentPane().add(alphas);

        a.gridwidth = GridBagConstraints.REMAINDER;
        rules = new JComboBox();
        layOut.setConstraints(rules, a);
        rules.addItem("SRC");
        rules.addItem("DST_IN");
        rules.addItem("DST_OUT");
        rules.addItem("DST_OVER");
        rules.addItem("SRC_IN");
        rules.addItem("SRC_OVER");
        rules.addItem("SRC_OUT");
        rules.addItem("CLEAR");
        rules.addItemListener(this);
        getContentPane().add(rules);

        GridBagConstraints fC = new GridBagConstraints();
        fC.fill = GridBagConstraints.BOTH;
        fC.weightx = 1.0;
        fC.weighty = 1.0;
        fC.gridwidth = GridBagConstraints.REMAINDER;
        comp = new CompPanel();
        layOut.setConstraints(comp, fC);
        getContentPane().add(comp);

        validate();
    }

    /*
     * Detects a change in either of the Choice components.  Resets the variable corresponding
     * to the Choice whose state is changed.  Invokes changeRule in CompPanel with the current
     * alpha and composite rules.
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        Object choice = e.getSource();
        if (choice == alphas) {
            alpha = (String) alphas.getSelectedItem();
        } else {
            rule = rules.getSelectedIndex();
        }
        comp.changeRule(alpha, rule);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("Composite");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet = new Composite();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.setVisible(true);
    }
}
