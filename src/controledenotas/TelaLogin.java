package controledenotas;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame implements ActionListener{
    ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
    JLabel lbl_icon = new JLabel(logo);
    Button b1 = new Button("Login");
    Button b2 = new Button("Cadastrar professor");
    JLabel l1 =new JLabel("ID:");
    JLabel l2 =new JLabel("Senha:");
    JTextField txt_id= new JTextField();
    JTextField txt_nome= new JTextField();
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        JOptionPane.showMessageDialog(null,"Implentar o login");
        dispose();
        new TelaPrincipal().setVisible(true);
        }
            
        else
            JOptionPane.showMessageDialog(null,"Implentar o cadastro");
    }
    

    public TelaLogin() {
        
        setLayout(null);
        b1.setBounds(320, 150, 100, 40);
        b2.setBounds(100, 150, 200, 40);
        add(b1);
        add(b2);
        
        lbl_icon.setBounds(50, 10, 120, 120);
        add(lbl_icon);
        l1.setBounds(200, -1, 200, 60);
        //l1.setHorizontalAlignment(SwingConstants.CENTER); //Alinha o texto
        l2.setBounds(194, 45, 200, 60);
        add(l1);
        add(l2);
        
        txt_id.setBounds(250, 18, 150, 20);
        txt_nome.setBounds(250, 65, 150, 20);
        add(txt_id);
        add(txt_nome);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setTitle("Login");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin();
        
        
    }

    
}
