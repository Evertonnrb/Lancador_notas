package br.com.uniderp.view;

import br.com.uniderp.controller.AlunoDao;
import br.com.uniderp.model.Aluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastrar extends JFrame implements ActionListener {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //persistencia

    private void _validarAluno() {

        if (txt_ra.getText().equals("") || txt_nome.getText().equals("") || txt_disciplina.getText().equals(""
                + "") || txt_curso.equals("") || txt_n1.equals("") || txt_n2.equals("") || txt_n3.equals("") || txt_n4.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha os campo", "Atenção", 1);

        }

    }
    
    private void _validaNotas(){
         if (Double.parseDouble(txt_n1.getText()) >= 11 || Double.parseDouble(txt_n1.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Campo N1 inválido", "Atenção", 1);
            } else if (Double.parseDouble(txt_n2.getText()) > 10 || Double.parseDouble(txt_n2.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Campo N2 inválido", "Atenção", 1);
            } else if (Double.parseDouble(txt_n3.getText()) > 10 || Double.parseDouble(txt_n3.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Campo N3 inválido", "Atenção", 1);
            } else if (Double.parseDouble(txt_n4.getText()) > 10 || Double.parseDouble(txt_n4.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Campo N4 inválido", "Atenção", 1);
            }
    }

    private void _limpaTelaCadastrar() {
        txt_ra.setText("");
        txt_nome.setText("");
        txt_curso.setText("");
        txt_disciplina.setText("");
        txt_n1.setText("");
        txt_n2.setText("");
        txt_n3.setText("");
        txt_n4.setText("");
    }

    //instancia de objetos
    JLabel lbl_nome = new JLabel("Nome:");
    JTextField txt_nome = new JTextField();
    JLabel lbl_ra = new JLabel("RA:");
    JTextField txt_ra = new JTextField();
    //JButton btn_cad = new JButton("Cadastrar aluno");
    JLabel lbl_n1 = new JLabel("N1: ");
    JTextField txt_n1 = new JTextField();
    JLabel lbl_n2 = new JLabel("N2: ");
    JTextField txt_n2 = new JTextField();
    JLabel lbl_n3 = new JLabel("N3: ");
    JTextField txt_n3 = new JTextField();
    JLabel lbl_n4 = new JLabel("N4: ");
    JTextField txt_n4 = new JTextField("n4");
    JButton btn_salvar = new JButton("Salvar");
    JButton btn_sair = new JButton("Sair");
    JLabel lbl_curso = new JLabel("Curso:");
    JTextField txt_curso = new JTextField();
    JLabel lbl_disciplina = new JLabel("Disciplina :");
    JTextField txt_disciplina = new JTextField();

    public TelaCadastrar() {
        //adicionando ao frame
        setTitle("Tela de cadatro de alunos");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        add(lbl_ra).setBounds(50, 10, 100, 100);
        add(txt_ra).setBounds(150, 45, 150, 25);
        add(lbl_nome).setBounds(50, 60, 100, 100);
        add(txt_nome).setBounds(150, 100, 250, 25);
        //add(btn_cad).setBounds(430, 100, 150, 30);

        add(lbl_curso).setBounds(50, 100, 130, 100);
        add(txt_curso).setBounds(150, 134, 250, 25);
        add(lbl_disciplina).setBounds(50, 140, 190, 100);
        add(txt_disciplina).setBounds(150, 175, 250, 25);

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
        //btn_cad.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_salvar) {

            Aluno alu = new Aluno();
            _validarAluno();
            _validaNotas();
            alu.setRa(Integer.parseInt(txt_ra.getText()));
            alu.setNome(txt_nome.getText());
            alu.setCurso(txt_curso.getText());
            alu.setDisciplina(txt_disciplina.getText());
            alu.setN1(Double.parseDouble(txt_n1.getText()));
            alu.setN2(Double.parseDouble(txt_n2.getText()));
            alu.setN3(Double.parseDouble(txt_n3.getText()));
            alu.setN4(Double.parseDouble(txt_n4.getText()));

            AlunoDao alunoDao = new AlunoDao();
            alunoDao.cadastrarAluno(alu);
            alunoDao.calcularM1(alu);
            _limpaTelaCadastrar();
        }

        if (e.getSource() == btn_sair) {
            int opc = JOptionPane.showConfirmDialog(null, "Deseja sair", "Ateção", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {

                dispose();
            }

        }
    }

}
