
package br.com.uniderp.controller;

import br.com.uniderp.model.Aluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RelatorioDao {
    private Connection con;

    public void conectar() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "postgres";

        String url = "jdbc:postgresql://localhost:5432/db_escola2";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso.");

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public void executar(String sql) {
        try {
            Statement cmd = con.createStatement();
            cmd.executeUpdate(sql);
            cmd.close();
        } catch (SQLException e) {
            System.out.println("Erro de SQL!");
        }
    }
    public ResultSet executarConsulta (String sql) {
        ResultSet cs = null;
        try {
            Statement cmd = con.createStatement();
            cs = cmd.executeQuery(sql);
            //cmd.close();
        } catch (SQLException e) {
            System.out.println("Erro de SQL!");
        }
        return cs;
    }

    public void fechar() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
    }
    public void melhor(Aluno aluno){
        String sql = "";
    }

}
