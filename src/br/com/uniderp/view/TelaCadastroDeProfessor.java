package br.com.uniderp.view;

import br.com.uniderp.controller.ProfessorDao;
import br.com.uniderp.model.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastroDeProfessor extends JFrame implements ActionListener {

    JLabel lbl_texto = new JLabel("Cadastro de professores");
    JLabel lbl_nome = new JLabel("Nome do professor");
    JTextField txt_nome = new JTextField();
    JLabel lbl_login = new JLabel("Login: ");
    JTextField txt_login = new JTextField();
    JLabel lbl_senha = new JLabel("Informe uma senha: ");
    JPasswordField txt_senha = new JPasswordField();
    JLabel lbl_senha_confirma = new JLabel("Redigite a senha: ");
    JPasswordField txt_senha_confirma = new JPasswordField();
    JButton btn_salvar = new JButton("Salvar");
    JButton btn_sair = new JButton("Sair");

    public TelaCadastroDeProfessor() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        setTitle("Cadastrar porfessores:");
        add(lbl_texto).setBounds(150, 12, 250, 20);
        add(lbl_nome).setBounds(30, 60, 150, 25);
        add(txt_nome).setBounds(190, 60, 250, 20);
        add(lbl_login).setBounds(30, 90, 150, 25);
        add(txt_login).setBounds(190, 90, 250, 20);
        add(lbl_senha).setBounds(30, 120, 150, 25);
        add(txt_senha).setBounds(190, 120, 250, 20);
        add(lbl_senha_confirma).setBounds(30, 150, 150, 25);
        add(txt_senha_confirma).setBounds(190, 150, 250, 20);
        add(btn_salvar).setBounds(130, 220, 90, 25);
        add(btn_sair).setBounds(250, 220, 90, 25);
        btn_salvar.addActionListener(this);
        btn_sair.addActionListener(this);

    }

    public static void main(String[] args) {
        new TelaCadastroDeProfessor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_salvar) {
            if (txt_senha.getText().equals(txt_senha_confirma.getText())) {
                Professor professor = new Professor();
                professor.setNome(txt_nome.getText());
                professor.setLogin(txt_login.getText());
                professor.setSenha(txt_senha.getText());

                ProfessorDao professorDao = new ProfessorDao();
                professorDao.cadastrarProfessor(professor);
                
            } else {
                JOptionPane.showMessageDialog(null, "As senha devem ser iguais");
                txt_senha.setText("");
                txt_senha_confirma.setText("");
                
                

            }

        }
        if (e.getSource() == btn_sair) {
            new TelaLogin();
            this.dispose();
        }
    }
}
