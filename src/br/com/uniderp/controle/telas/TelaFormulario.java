package br.com.uniderp.controle.telas;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//defaultTableModel

public class TelaFormulario extends JFrame {

    JTable tabela = new JTable();

    public TelaFormulario() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Relatorio");
        setVisible(true);
        setSize(700, 700);
        setLocationRelativeTo(null);
        
        tabela.setModel(new DefaultTableModel(new Object[][]
        {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        
        },
                new String[]{"RA","Nome","N1","N2"}
                
                
));
        add(tabela);
        tabela.setBounds(50, 100, 400, 400);
    }

    public static void main(String[] args) {
        new TelaFormulario();
    }

}
