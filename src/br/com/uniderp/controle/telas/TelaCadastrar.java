package br.com.uniderp.controle.telas;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        private void cadastrarAluno(){
        String sql = "insert into tbl_aluno (ra,nome_aluno) values (?,?)";
       if(! txt_ra.getText().equals("") && ! txt_nome.getText().equals("")){
            try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txt_ra.getText()));
            pst.setString(2, txt_nome.getText());
            pst.executeUpdate();
//            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro = "+ e);
        }
       }
       else{
           JOptionPane.showMessageDialog(null, "Preencha os campo","Atenção",0);
       }
    }
        
            public void lancarNotas(){
        String sql = "insert into tbl_nota(cod_nota,n1,n2,n3,n4,cod_disciplina,ra)values(?,?,?,?,?,?,?)";
       if((! txt_n1.getText().equals(""))){
            try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(txt_nota.getText()));
            pst.setDouble(2,Double.parseDouble(txt_n1.getText()));
            pst.setDouble(3,Double.parseDouble(txt_n2.getText()));
            pst.setDouble(4,Double.parseDouble(txt_n3.getText()));
            pst.setDouble(5,Double.parseDouble(txt_n4.getText()));
            pst.setInt(6, Integer.parseInt(txt_disciplina.getText()));
            pst.setInt(7, Integer.parseInt(txt_ra.getText()));
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro = "+ e);
        }
       }
    }
    //instancia de objetos
    JLabel lbl_nome = new JLabel("Nome:");
    JTextField txt_nome = new JTextField("esse nome");
    JLabel lbl_ra = new JLabel("RA:");
    JTextField txt_ra = new JTextField(" ess ra");
    JButton btn_cad = new  JButton("Cadastrar aluno");
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
    JLabel lbl_nota = new JLabel("Código nota:"); 
    JTextField txt_nota = new JTextField("...nota");
    JLabel lbl_disciplina = new JLabel("Código da Disciplina :"); 
    JTextField txt_disciplina = new JTextField("...disciplina");

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
        add(btn_cad).setBounds(430, 100, 150, 30);
        
        add(lbl_disciplina).setBounds(40, 130, 190, 100);
        add(txt_disciplina).setBounds(200, 169, 70, 20);
        add(lbl_nota).setBounds(360,129 ,190,100);
        add(txt_nota).setBounds(480, 169, 70, 20);
       
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
        btn_cad.addActionListener(this);
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_salvar) {
            lancarNotas();
        }
        if(e.getSource() == btn_cad){
           cadastrarAluno();
        }
        if (e.getSource() == btn_sair) {
            int opc = JOptionPane.showConfirmDialog(null, "Deseja sair", "Ateção", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                //System.exit(0);
                dispose();
            }

        }
    }
    public static void main(String[] args) {
        new TelaCadastrar();
    }
    
}
