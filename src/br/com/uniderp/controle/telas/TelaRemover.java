package br.com.uniderp.controle.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaRemover extends JFrame implements ActionListener {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    JLabel lbl_txt = new JLabel("Digite o RA do aluno a ser removido");
    JLabel lbl_remove = new JLabel("RA:");
    JTextField txt_remove = new JTextField("remover");
    JButton btn_excluir = new JButton("Excluir");
    JButton btn_cancelar = new JButton("Cancelar");
    
    private void remove(){
        String sql = "delete from tbl_aluno where ra = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txt_remove.getText()));
            pst.executeQuery();
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso","confirmação",2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar "+e+ " ","confirmação",2);
            
        }
    }

    public TelaRemover() {
        setVisible(true);
        setTitle("Remover aluno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);

        add(lbl_txt).setBounds(150, 10, 350, 30);
        add(lbl_remove).setBounds(150, 100, 120, 30);
        add(txt_remove).setBounds(200, 100, 220, 30);
        add(btn_cancelar).setBounds(300, 290, 120, 30);
        add(btn_excluir).setBounds(450, 290, 90, 30);
        btn_cancelar.addActionListener(this);
        btn_excluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (txt_remove.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo RA");
        } else {
            if (e.getSource() == btn_cancelar) {
                dispose();
            }
            if (e.getSource() == btn_excluir) {
                int opc = JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir", "Operação"
                        + "não pode ser desfeita", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    remove();
                } else {
                    dispose();
                }
            }
        }
    }
}
