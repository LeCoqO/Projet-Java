package projetjava;

import javax.swing.*;
import java.awt.GridLayout;

public class menu extends JFrame {
    private JButton boutonStats = new JButton("Statistiques");
    private JButton boutonGC = new JButton("Gestion des campagnes");
    private JButton boutonGU = new JButton("Gestion des utilisateurs");
    private JPanel panneauMenu = new JPanel(new GridLayout(3,1));
    

    public menu() {
        super("Menu de naviagation");  
        panneauMenu.add(this.boutonStats);
        panneauMenu.add(this.boutonGC);
        panneauMenu.add(this.boutonGU);
        this.getContentPane().add(this.panneauMenu);
    }
}

