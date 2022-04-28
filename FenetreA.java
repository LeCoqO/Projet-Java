package projetjava;

import java.io.IOException;

import javax.swing.*;

public class FenetreA {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login fenetreLog = new login();
                fenetreLog.setSize(300, 200);
                fenetreLog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fenetreLog.setVisible(true);

                menu fenetreMenu = new menu();
                fenetreMenu.setSize(300, 150);
                fenetreMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fenetreMenu.setVisible(true);

                stats fenetreStats;
                try {
                    fenetreStats = new stats();
                    fenetreStats.setSize(800, 400);
                    fenetreStats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    fenetreStats.setVisible(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                gestionUser fenetreGestionUser;
                try {
                    fenetreGestionUser = new gestionUser();
                    fenetreGestionUser.setSize(800, 400);
                    fenetreGestionUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    fenetreGestionUser.setVisible(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                gestionCampagne fenetreGestionCampagne;
                try {
                    fenetreGestionCampagne = new gestionCampagne();
                    fenetreGestionCampagne.setSize(800, 400);
                    fenetreGestionCampagne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    fenetreGestionCampagne.setVisible(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}