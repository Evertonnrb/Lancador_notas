package br.com.uniderp.view;

import br.com.uniderp.controller.RelatorioDao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaFormulario extends JFrame implements ActionListener {

    JPanel painel1, painel2;
    JTable /*tabela1,*/ tabela2;
    JScrollPane /*tabela1,*/ barraRolagem2;
    JTabbedPane painelPrincipal;
    JButton btn_sair = new JButton("Sair");
    JLabel lbl_mediaReprovados = new JLabel("Total de alunos reprovados: ");
    JLabel lbl_num_tot = new JLabel("esses");
    JLabel lbl_melhor = new JLabel("Melhor aluno da sala :");
    JLabel lbl_nome_melhor = new JLabel("O cara");

    public void criaJanela() {

        painelPrincipal = new JTabbedPane();

        painel1 = new JPanel();
        painel2 = new JPanel();

        painel2.setLayout(new GridLayout(2, 2));

        tabela2 = new JTable();
        DefaultTableModel modelo = (DefaultTableModel) tabela2.getModel();

        modelo.setColumnIdentifiers("id;ra;nome;disciplina;curso;n1;n2;n3;n4;m1;m2;mf;situaçao".split(";"));

        RelatorioDao cx = new RelatorioDao();
        cx.conectar();
        ResultSet rs = cx.executarConsulta("select * from tbl_aluno");
        try {
            while (rs.next()) {
                Object[] linha = new Object[13];
                for (int i = 0; i < 13; i++) {
                    linha[i] = rs.getObject(i + 1);
                }
                modelo.addRow(linha);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelaFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabela2.setModel(modelo);
        barraRolagem2 = new JScrollPane(tabela2);
        painel2.add(barraRolagem2);

        painelPrincipal.addTab("Relátorio de notas", painel2);
        getContentPane().add(painelPrincipal);
        painelPrincipal.addTab("Relatório detalhado", painel1);
        getContentPane().add(painelPrincipal);
        painel1.setLayout(null);
        painel1.add(lbl_mediaReprovados).setBounds(50, 80, 250, 25);
        painel1.add(lbl_num_tot).setBounds(400, 80, 200, 25);
        painel1.add(lbl_melhor).setBounds(50, 120, 250, 25);
        painel1.add(lbl_nome_melhor).setBounds(400, 120, 200, 25);
        painel1.add(btn_sair).setBounds(850, 450, 120, 25);
        btn_sair.addActionListener(this);
        lbl_melhor.setText("");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        TelaFormulario app = new TelaFormulario();
        app.criaJanela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_sair) {
            int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair? "
                    + "", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                System.exit(0);

            }
        }
    }
}
