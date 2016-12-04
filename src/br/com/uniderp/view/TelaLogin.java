package br.com.uniderp.view;

import br.com.uniderp.conexao.ModuloDeConexao;
import br.com.uniderp.controller.ProfessorDao;
import br.com.uniderp.model.Professor;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener {

    //variacveis para persistencia
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

//    public void cadastarProfessor(){
//        String sql = "insert into tbl_professor (cod_professor,nome_professor,login,senha)values(?,?,?,?)";
//        try {
//               
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro = "+e,"Erro",2);
//        }
//    }
    public void logar() {
        String sql = "select * from tbl_professor where login = ? and senha = ?";
        if (!txt_id.getText().equals("") && !txt_pwd.getText().equals("")) {
            try {
                //iniciando a consulta no bd
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_id.getText());
                pst.setString(2, txt_pwd.getText());
                rs = pst.executeQuery();
                if (rs.next()) {

                    dispose();
                    new TelaPrincipal().setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválidos");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error = tela login " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos");
        }
    }
    ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
    JLabel lbl_icon = new JLabel(logo);
    Button b1 = new Button("Login");
    Button b2 = new Button("Cadastrar professor");
    JLabel l1 = new JLabel("ID:");
    JLabel l2 = new JLabel("Senha:");
    JTextField txt_id = new JTextField();
    JTextField txt_nome = new JTextField("nome");
    JPasswordField txt_pwd = new JPasswordField();
    JLabel lbl_status = new JLabel("on");
    JLabel lbl_status2 = new JLabel("off");
    JLabel lbl_status1 = new JLabel();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            logar();
            Professor p = new Professor();
            p.setLogin(txt_id.getText());
            p.setSenha(txt_pwd.getText());

            if (!txt_id.equals("") || txt_pwd.equals("")) {
                ProfessorDao professorControler = new ProfessorDao();
                Professor pRetorno = professorControler.logar(txt_id.getText(), txt_pwd.getText());

                //System.out.println(usuarioDao.buscaPorId(2).getNome());
                if (pRetorno != null) {
                    //System.out.println("nome " + usuRetorno.getNome());
                    TelaPrincipal telaPrincipal = new TelaPrincipal();
                    telaPrincipal.setVisible(true);
                    dispose();
                }

            }

        } else if (e.getSource() == b2) {

            new TelaCadastroDeProfessor();
            this.dispose();
        }
    }

    public TelaLogin() {
        //Estabelecendo a conexao com o banco
        conexao = ModuloDeConexao.getConnection();

        setLayout(null);
        b1.setBounds(320, 150, 100, 40);
        b2.setBounds(100, 150, 200, 40);
        add(b1);
        add(b2);

        lbl_icon.setBounds(50, 10, 120, 120);
        add(lbl_icon);
        l1.setBounds(200, -1, 200, 60);
        l2.setBounds(194, 45, 200, 60);
        add(l1);
        add(l2);
        //lbl_status.setBounds(200, 50, 64, 64);
        if (conexao != null) {
            add(lbl_status).setBounds(50, 190, 64, 64);
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/uniderp/icons/on.png")));
        } else {
            add(lbl_status).setBounds(50, 190, 64, 64);
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/uniderp/icons/off.png")));
        }
        txt_id.setBounds(250, 18, 150, 20);
        txt_pwd.setBounds(250, 65, 150, 20);
        add(txt_id);
        add(txt_pwd);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setTitle("Login");
        setSize(500, 300);
        //setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
