package br.com.uniderp.controle.notas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TelaSobre extends JFrame {

    JFrame sobre = new JFrame("Tela Sobre");
    JLabel txt_01 = new JLabel("Desenvolvido por Everton Ribeiro RA:3425746757");
//                ImageIcon img_logo = new ImageIcon("gnu.png");
//                JLabel lbl_logo = new JLabel(img_logo);

    public TelaSobre() {

        sobre.setSize(500, 300);
        sobre.setLayout(null);
        sobre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        sobre.setLocationRelativeTo(null);
        //sobre.add(lbl_logo).setBounds(50, 50, 100, 100);
        sobre.add(txt_01);
        txt_01.setBounds(100, 100, 350, 250);
    }

}
