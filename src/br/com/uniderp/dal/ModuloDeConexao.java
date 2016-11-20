package br.com.uniderp.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModuloDeConexao {

    public static Connection connector() {
        //criando a varialvel para conexao
        java.sql.Connection conexao = null;
        //chamamdo o driver
        String driver = "org.postgresql.Driver";
        //Armazenanando as informaçoes do banco 
        String url = "jdbc:postgresql://localhost:5432/db_lanca_notas";
        String usuario = "postgres";
        String senha = "postgres";
        
        //estabelecendo a conexao
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro = "+e);
            return null;
        }

//        // Criando a conexao com o banco
//        try {
//            //forçando o carregamento do driver 
//            Class.forName("org.postgresql.Driver");
//            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lanca_notas", "postgres", "postgres");
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            JOptionPane.showMessageDialog(null, "Error ao conectar ao banco " + e);
//            throw new RuntimeException(e);
//
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException(e);
//        }
    }
    
}
