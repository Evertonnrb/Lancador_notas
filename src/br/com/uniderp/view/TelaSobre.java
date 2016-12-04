package br.com.uniderp.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TelaSobre extends JFrame {

    JFrame sobre = new JFrame("Tela Sobre");
    JLabel txt_01 = new JLabel("Desenvolvido por Everton Ribeiro RA:3425746757");
    JLabel txt_02 = new JLabel("Desenvolvido por Jonatas Marques Simeoni RA:9927001387");
    ImageIcon img_logo = new ImageIcon(getClass().getResource("gnu.jpeg"));
    JLabel lbl_logo = new JLabel(img_logo);

    public TelaSobre() {

        setVisible(true);
        setBackground(Color.DARK_GRAY);
        setTitle("Sobre");
        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        lbl_logo.setBounds(220, -70, 400, 400);
        add(lbl_logo);
        add(txt_01).setBounds(50, 220, 800, 300);;
        add(txt_02).setBounds(50, 230, 500, 350);

    }


}
