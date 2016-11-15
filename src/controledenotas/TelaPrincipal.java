
package controledenotas;

import javax.swing.JFrame;

public class TelaPrincipal extends JFrame{

    public TelaPrincipal() {
        setTitle("Tela principal");
        setSize(800, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TelaPrincipal();
    }
    
}
