
package br.com.uniderp.controller;

import br.com.uniderp.dal.ModuloDeConexao;
import br.com.uniderp.entidades.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlunoDao {
    private Connection con = ModuloDeConexao.connector();
   
    public void cadastrarAluno(Aluno aluno){
        String sql = "insert into aluno (nome,n1,n2) values(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,aluno.getNome());
            pst.setDouble(2, aluno.getN1());
            pst.setDouble(3, aluno.getN2());
            pst.execute();
        } catch (Exception e) {
        }
    }
}
