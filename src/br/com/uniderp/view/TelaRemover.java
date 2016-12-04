package br.com.uniderp.view;

import br.com.uniderp.controller.AlunoDao;
import br.com.uniderp.conexao.ModuloDeConexao;
import br.com.uniderp.model.Aluno;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaRemover extends JFrame implements ActionListener {

    //pequisar nome do aluno
    private void pesquisarPorRa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select nome from tbl_aluno where ra =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txt_consulta.getText()));
            rs = pst.executeQuery();
            if (rs.next()) {
                String aln = rs.getString(3);
                JOptionPane.showMessageDialog(null, "Aluno " + aln);
                
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado", "confirmação", 2);
                
            }
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    JLabel lbl_consultar = new JLabel("Digite o ra");
    JTextField txt_consulta = new JTextField("consultar");
    //ImageIcon img_pesq = new ImageIcon("/br/com/uniderp/icons/fing.png");
    JButton btn_consultar = new JButton();
    JLabel lbl_txt = new JLabel("Digite o RA do aluno a ser removido");
    JLabel lbl_remove = new JLabel("RA:");
    JTextField txt_remove = new JTextField();
    JButton btn_excluir = new JButton("Excluir");
    JButton btn_cancelar = new JButton("Cancelar");

    public TelaRemover() {

        setVisible(true);
        setTitle("Remover aluno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setPreferredSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        pack();

        add(lbl_consultar).setBounds(150, 50, 120, 30);
        add(txt_consulta).setBounds(250, 50, 120, 30);
        add(btn_consultar).setBounds(400, 50, 40, 30);
        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource(""
                + "/br/com/uniderp/icons/find.png")));
        add(lbl_txt).setBounds(150, 140, 350, 30);
        add(lbl_remove).setBounds(150, 170, 120, 30);
        add(txt_remove).setBounds(200, 170, 220, 30);
        add(btn_cancelar).setBounds(300, 290, 120, 30);
        add(btn_excluir).setBounds(450, 290, 90, 30);
        btn_cancelar.addActionListener(this);
        btn_excluir.addActionListener(this);
        btn_consultar.addActionListener(this);
        //Double pmt = pv*i /(1-(1/Math.pow((1+i), n)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_consultar) {
            pesquisarPorRa();
        }
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

                    Aluno aluno = new Aluno();
                    aluno.setRa(Integer.parseInt(txt_remove.getText()));

                    AlunoDao alunoDao = new AlunoDao();
                    alunoDao.removerAluno(aluno);

                } else {
                    dispose();
                }
            }
        }
    }

}
