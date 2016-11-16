package br.com.uniderp.controle.notas;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastrar extends JFrame implements ActionListener {

    JLabel lbl_nome = new JLabel("Nome:");
    JTextField txt_nome = new JTextField("nome");
    JLabel lbl_ra = new JLabel("RA:");
    JTextField txt_ra = new JTextField("ra");
    JLabel lbl_n1 = new JLabel("N1: ");
    JTextField txt_n1 = new JTextField("n1");
    JLabel lbl_n2 = new JLabel("N2: ");
    JTextField txt_n2 = new JTextField("n2");
    JLabel lbl_n3 = new JLabel("N3: ");
    JTextField txt_n3 = new JTextField("n3");
    JLabel lbl_n4 = new JLabel("N4: ");
    JTextField txt_n4 = new JTextField("n4");
    JButton btn_salvar = new JButton("Salvar");
    JButton btn_sair = new JButton("Sair");

    public TelaCadastrar() {
        setTitle("Tela de cadatro de alunos");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(800, 600);
        add(lbl_ra).setBounds(50, 10, 100, 100);
        add(txt_ra).setBounds(150, 45, 150, 25);

        add(lbl_nome).setBounds(50, 60, 100, 100);
        add(txt_nome).setBounds(150, 100, 250, 25);
        add(lbl_n1).setBounds(50, 200, 50, 50);
        add(txt_n1).setBounds(120, 215, 50, 20);
        add(lbl_n2).setBounds(50, 240, 50, 50);
        add(txt_n2).setBounds(120, 255, 50, 20);
        add(lbl_n3).setBounds(300, 200, 50, 50);
        add(txt_n3).setBounds(350, 215, 50, 20);
        add(lbl_n4).setBounds(300, 240, 50, 50);
        add(txt_n4).setBounds(350, 255, 50, 20);
        add(btn_salvar).setBounds(100, 350, 100, 30);
        add(btn_sair).setBounds(300, 350, 100, 30);
        btn_salvar.addActionListener(this);
        btn_sair.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_salvar) {

        }
        if (e.getSource() == btn_sair) {
            int opc = JOptionPane.showConfirmDialog(null, "Deseja sair", "Ateção", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                //System.exit(0);
                dispose();
            }

        }
    }

}
