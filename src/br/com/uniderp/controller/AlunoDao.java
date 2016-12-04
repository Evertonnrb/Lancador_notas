package br.com.uniderp.controller;

import br.com.uniderp.conexao.ModuloDeConexao;
import br.com.uniderp.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class AlunoDao {

    private Connection con = ModuloDeConexao.getConnection();

    public static void cadastrar(Aluno aluno) {
        Connection con = null;
        if (aluno != null) {
            try {
                con = ModuloDeConexao.getConnection();
                PreparedStatement pst;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro = " + e);
            }
        }
    }

    public void cadastrarAluno(Aluno aluno) {
        String sql = "insert into tbl_aluno(ra,nome,curso,disciplina,n1,n2,n3,n4,m1,m2,mf,situacao)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.getConnection();
            pst.setInt(1, aluno.getRa());
            pst.setString(2, aluno.getNome());
            pst.setString(3, aluno.getCurso());
            pst.setString(4, aluno.getDisciplina());
            pst.setDouble(5, aluno.getN1());
            pst.setDouble(6, aluno.getN2());
            pst.setDouble(7, aluno.getN3());
            pst.setDouble(8, aluno.getN4());
            pst.setDouble(9, aluno.calculaM1(aluno.getN1(), aluno.getN2()));
            pst.setDouble(10, aluno.calculaM2(aluno.getN3(), aluno.getN4()));
            pst.setDouble(11, aluno.calcualMediaFinal());
            pst.setString(12, aluno.situacao(aluno.calcualMediaFinal()));
            pst.execute();
            System.out.println("Cadastrado");

            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso ", "Sucesso", 2);
            pst.close();

        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public void removerAluno(Aluno aluno) {
        String sql = "delete from tbl_aluno where ra = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.getConnection();
            pst.setInt(1, aluno.getRa());
            pst.execute();
            System.out.println("Excluido");
            JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso ", "Sucesso", 1);
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro tela excluir " + e);
        }
    }

    //gambiarra
    public void calculaMd(Aluno aluno) {

        String sql = "insert into tbl_aluno  values(m1,"
                + "" + aluno.calculaM1(aluno.getN1(), aluno.getN2()) + ",m2,"
                + "" + aluno.calculaM2(aluno.getN3(), aluno.getN4()) + ",mf,"
                + "" + aluno.calcualMediaFinal() + ",sitacao, "
                + "" + aluno.situacao(aluno.calcualMediaFinal()) + ")";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.getConnection();
            pst.execute();
        } catch (Exception e) {
            System.out.println("Erro " + e);
            e.printStackTrace();
        }

    }

    public void calcularM1(Aluno aluno) {
        String sql = "select((n1+n2)/2) as media from tbl_aluno";
        
        try {
            aluno = new Aluno();
            PreparedStatement pst  = con.prepareCall(sql);
            pst.getConnection();
            pst.setDouble(1, aluno.getMb1());
            pst.executeQuery();
        } catch (Exception e) {
        }
    }
}
