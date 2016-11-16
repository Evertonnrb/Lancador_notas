package br.com.uniderp.controle.notas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TelaPrincipal extends JFrame {
    
    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("Opçoes");
    JMenu m2 = new JMenu("Sobre");
    JMenu m3 = new JMenu("Sair");
    
    JMenuItem i1 = new JMenuItem("Cadastrar aluno");
    JMenuItem i2 = new JMenuItem("Remover aluno");
    JMenuItem i3 = new JMenuItem("Lançar notas");
    JMenuItem i4 = new JMenuItem("Relatorio de notas");
    JPanel painel = new JPanel();
    
    JButton test = new JButton("TESTE");
    
    public TelaPrincipal() {
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
        m2.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                new TelaSobre();
            }
            
            @Override
            public void menuDeselected(MenuEvent e) {
            }
            
            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        menuBar.add(m3);
        m3.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair? "
                        + "", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    System.exit(0);
                    
                } else if (opc == JOptionPane.NO_OPTION) {
                    dispose();
                } else {
                    dispose();
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
        m1.add(i3);
        m1.add(i4);
        //Panel
        painel.setBackground(Color.DARK_GRAY);
        add(painel);
        
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == i2){
//            System.out.println("chamou");
//        }
//    }
}
