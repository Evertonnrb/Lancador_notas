
package controledenotas;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ControleDeNotas extends JFrame{
    private JTextField txtNome;
    private JButton btnOk;

    public ControleDeNotas(){
        setTitle("Tela de login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400,400);
        
        JTextField txtNome = new JTextField("Nome:");
        add(txtNome,BorderLayout.CENTER);
        
        Button tbnOk = new Button("OK");
        add(txtNome,BorderLayout.CENTER);
        
        
        
        
    }
    
    public static void main(String[] args) {
       new ControleDeNotas();
    }
}
    
    

