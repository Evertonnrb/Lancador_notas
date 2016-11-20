package br.com.uniderp.controller;

import br.com.uniderp.dal.ModuloDeConexao;
import br.com.uniderp.entidades.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AlunoDao {

    private Connection con = ModuloDeConexao.connector();

//    public void cadastrarAluno(Aluno aluno) {
//        String sql = "insert into aluno (nome,n1,n2) values(?,?,?)";
//        try {
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, aluno.getNome());
//            pst.setDouble(2, aluno.getN1());
//            pst.setDouble(3, aluno.getN2());
//            pst.execute();
//        } catch (Exception e) {
//        }
//    }

    public void cadastrarAluno(Aluno aluno) {
    String sql = "insert into tbl_aluno( ra, nome_aluno)values(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, aluno.getRa());
            pst.setString(2, aluno.getNome());
            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro feio "+ e);
        }
    }
    public void excluir(Aluno aluno){
        String sql = "delete from tbl_aluno where ra = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)){
            pst.setInt(1, aluno.getRa());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+e);
        }
    }
}
