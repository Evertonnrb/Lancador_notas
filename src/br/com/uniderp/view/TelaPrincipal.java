package br.com.uniderp.view;

import br.com.uniderp.conexao.ModuloDeConexao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TelaPrincipal extends JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("Opçoes");
    JMenu m2 = new JMenu("Sobre");
    JMenu m3 = new JMenu("Sair");

    JMenuItem i1 = new JMenuItem("Cadastrar aluno");
    JMenuItem i2 = new JMenuItem("Remover aluno");
    //JMenuItem i3 = new JMenuItem("Lançar notas");
    JMenuItem i4 = new JMenuItem("Relatorio de notas");
    JMenuItem i5 = new JMenuItem("Sobre o software");
    JPanel painel = new JPanel();

    JButton test = new JButton("TESTE");

    public TelaPrincipal() {
        conexao = ModuloDeConexao.getConnection();
        //Frame
        setTitle("Tela principal");
        setSize(800, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //JMenu
        setJMenuBar(menuBar);
        menuBar.add(m1);
        menuBar.add(m2);

        menuBar.add(m3);
        m3.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair? "
                        + "", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    System.exit(0);

                } else if (opc == JOptionPane.NO_OPTION) {

                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        //JMenuIten                
        m1.add(i1);
        //cadastrar aluno
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastrar();
            }
        });
        m1.add(i2);
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRemover();
            }
        });
        //m1.add(i3);
        m1.add(i4);
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               TelaFormulario telaFormulario =  new TelaFormulario();
               telaFormulario.criaJanela();
               dispose();
            }
        });
        m2.add(i5);
        i5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSobre();
            }
        });

        //Panel
        painel.setBackground(Color.DARK_GRAY);
        add(painel);

    }

}
