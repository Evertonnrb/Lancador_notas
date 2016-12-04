
package br.com.uniderp.controller;

import br.com.uniderp.conexao.ModuloDeConexao;
import br.com.uniderp.model.Professor;
import br.com.uniderp.view.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ProfessorDao {
    private Connection con = ModuloDeConexao.getConnection();
    
    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public Professor logar(String login, String senha) {
        String sql = "SELECT * FROM tbl_professor WHERE login=? AND senha=?";
        Professor p = null;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p = new Professor();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setLogin(rs.getString("login"));
                p.setSenha(rs.getString("senha"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        return p;
    }

    public void cadastrarProfessor(Professor professor) {
        String sql = "insert into tbl_professor (nome,login,senha)values(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.getConnection();
            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getLogin());
            pst.setString(3, professor.getSenha());
            pst.execute();
            System.out.println("Professor cadastrado");
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro tela cadastrar professor "+ e);
        }
    }
}
