
package br.com.uniderp.controle.telas;

import br.com.uniderp.controller.AlunoDao;
import br.com.uniderp.entidades.Aluno;

public class FrmPrincipal {
//    Connection conexao = null;
//    PreparedStatement stm = null;
//    ResultSet rs = null;
     public static void main(String[] args) {
        new TelaLogin();
        Aluno aluno = new Aluno();
       AlunoDao aluDao = new AlunoDao();
       aluDao.cadastrarAluno(aluno);
       
        
    }

}
