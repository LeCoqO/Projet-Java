package projet.java;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class testInterface extends JFrame {

    public testInterface() {
        super("Bonjouuuur");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel panneau = (JPanel) this.getContentPane();
        panneau.setLayout(new FlowLayout(FlowLayout.LEFT));
        panneau.add(new JButton("ah oui oui"));
        panneau.add(new JButton("ah non non"));
        panneau.add(new Checkbox("Click batard !"));
        panneau.add(new JTextField("Ecrit chien !"));
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Appliquer un theme
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        // Démarrer la fenêtre
        testInterface maFenetre = new testInterface();
        maFenetre.setVisible(true);
    }
}
