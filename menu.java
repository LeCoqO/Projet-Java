package projetjava;

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
        if(e.getSource() == boutonStats) { 
            try {
                stats mesStats = new stats();
                mesStats.setBounds(0,0,800,400); 
                mesStats.setVisible(true);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        } else if(e.getSource() == boutonGU) {
            try {
                gestionUser mesUsers = new gestionUser();
                mesUsers.setBounds(0,0,800,400); 
                mesUsers.setVisible(true);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if(e.getSource() == boutonGC) {
            try {
                gestionCampagne mesCampagnes = new gestionCampagne();
                mesCampagnes.setBounds(0,0,800,400); 
                mesCampagnes.setVisible(true);
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
    }
}

