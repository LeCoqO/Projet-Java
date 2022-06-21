package Interface;


import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class menu extends JFrame implements ActionListener {
    private JButton boutonStats = new JButton("Statistiques");
    private JButton boutonGC = new JButton("Gestion des campagnes");
    private JButton boutonGU = new JButton("Gestion des utilisateurs");
    private JPanel panneauMenu = new JPanel(new GridLayout(3,1));
    

    public menu() {
        super("Menu de naviagation");  
        panneauMenu.add(this.boutonStats);
        panneauMenu.add(this.boutonGC);
        panneauMenu.add(this.boutonGU);
        boutonStats.addActionListener(this);
        boutonGU.addActionListener(this);
        boutonGC.addActionListener(this);
        this.getContentPane().add(this.panneauMenu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boutonStats) { // Si bouton stat cliqué alors on lance la fenetre des stats
            try {
                stats mesStats = new stats();
                mesStats.setBounds(0,0,1920,1080); 
                mesStats.setVisible(true);
                mesStats.setResizable(false);
                mesStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        } else if(e.getSource() == boutonGU) { // Si bouton gestion utilisateur est cliqué alors on lance la fenetre de gestion des utilisateurs
            try {
                gestionUser mesUsers = new gestionUser();
                mesUsers.setBounds(0,0,1920,1080); 
                mesUsers.setVisible(true);
                mesUsers.setResizable(false);
                mesUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if(e.getSource() == boutonGC) { // Si bouton gestion campagne est cliqué alors on lance la fenetre de gestion des campagne
            try {
                gestionCampagne mesCampagnes = new gestionCampagne();
                mesCampagnes.setBounds(0,0,1920,1080); 
                mesCampagnes.setVisible(true);
                mesCampagnes.setResizable(false);
                mesCampagnes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
    }
}

