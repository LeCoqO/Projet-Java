package Interface;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Connection.ConnectionBDD;
import Connection.Connector;
import Connection.ConnectorMySQL;

public class FenetreA {

    
    /** 
     * @param (ConnectionBDD.isInstanceOf(connector)
     * @return boolean
     * 
     * On test la connexion à la base de données
     */
    static boolean checkConnection(Connector connector) { // On test la connexion à la base

        if (ConnectionBDD.isInstanceOf(connector)) {
            System.out.println("La connexion à base " + connector.getNAME() + " est active");
             return true;
        } else {
            System.out.println("La connexion à base " + connector.getNAME() + " est inactive");
            return false;
         }
    }

    
    /** 
     * @param args
     * 
     * En premier on initialise la connexion
     * 
     * On invoque la première fenetre swing pour la page de connexion à l'application
     */
    public static void main(String[] args) {

        Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL()); // On initialise la connexion
        if (connection != null) {
            System.out.println("Connexion réussi !");
        }

        SwingUtilities.invokeLater(new Runnable() { // On lance la fenetre de connexion à l'application
            public void run() {
                login fenetreLog = new login();
                fenetreLog.setBounds(650,350,300,150);
                fenetreLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetreLog.setVisible(true);
                fenetreLog.setResizable(false);

            }
        });
    }
}
