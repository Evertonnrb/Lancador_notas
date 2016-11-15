package controledenotas;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Tela principal");
        setSize(800, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu m1 = new JMenu("Opçoes");
        JMenu m2 = new JMenu("Sobre");
        JMenu m3 = new JMenu("Sair");
        
       
        
        //Add menu
        setJMenuBar(menuBar);
        
        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);
        
        m3.addActionListener((e) -> {
            System.exit(0);
        });
        
        JMenuItem i1 = new JMenuItem("Cadastrar aluno");
        JMenuItem i2 = new JMenuItem("Remover aluno");
        JMenuItem i3 = new JMenuItem("Lançcar notas");
        JMenuItem i4 = new JMenuItem("Relatorio de notas");
        
       m1.add(i1);
       m1.add(i2);
       m1.add(i3);
       m1.add(i4);
    }
   

}
