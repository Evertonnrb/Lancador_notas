package br.com.uniderp.controller;
import br.com.uniderp.controle.telas.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioController {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
//    public void logar() {
//        String sql = "select *from tbl_professor where login = ? and senha = ?";
//        try {
//            //iniciando a consulta no bd
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, txt_id.getText());
//            pst.setString(2,txt_pwd.getText());
//            rs = pst.executeQuery(); 
//            if(rs.next()){
//                TelaPrincipal telaPrincipal = new TelaPrincipal();
//                
//           }else{
//                JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválidos");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error = " +e);
//        }
//    }
    
//    public void cadastrarAluno(){
//        String sql = "insert into tbl_aluno (ra,nome) values (?,?)";
//        try {
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, txt_ra.getText());
//            pst.setString(2,txt_nome.getText());
//            rs = pst.executeUpdate();
//            pst.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro = "+ e);
//        }
//    }
    

}
