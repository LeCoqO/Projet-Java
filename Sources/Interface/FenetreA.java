package Interface;

import java.sql.Connection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Connection.ConnectionBDD;
import Connection.Connector;
import Connection.ConnectorMySQL;
import DAO.DAOEmploye;
import Entity.Employe;

public class FenetreA {

    static boolean checkConnection(Connector connector) {

        if (ConnectionBDD.isInstanceOf(connector)) {
            System.out.println("La connexion à base " + connector.getNAME() + " est active");
             return true;
        } else {
            System.out.println("La connexion à base " + connector.getNAME() + " est inactive");
            return false;
         }
    }

    public static void main(String[] args) {

        Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
        if (connection != null) {
            System.out.println("Connexion réussi !");
        }
        System.out.println(connection);
        checkConnection(new ConnectorMySQL());
        DAOEmploye emp = new DAOEmploye(connection);
        List<Employe> le_emp = emp.getAll();
        for (Employe employe : le_emp) {
            System.out.println(employe);

        }

        SwingUtilities.invokeLater(new Runnable() {
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
