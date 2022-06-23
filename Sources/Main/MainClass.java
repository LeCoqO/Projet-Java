package Main;

import Connection.*;
import DAO.*;
import Entity.*;

import java.sql.*;
import java.util.List;

public class MainClass {

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
        DAOBatiment bat7 = new DAOBatiment(connection);
        List<Batiment> le_tieks = bat7.getAll();
        for (Batiment batiment : le_tieks) {
            System.out.println(batiment);
        }

        DAOEmploye daoEmploye = new DAOEmploye(connection);
        Employe employetest = new Employe(12, "Mauchand", "Coco", "coco123", "12345678", "Utilisateur");
        // Employe employeCoco = daoEmploye.create(emplyetest);
        boolean ok = daoEmploye.createWoID(employetest);
        System.out.println(ok);
        System.out.println(employetest);
        // Connection connection = ConnectionBDD.getInstance(new ConnectorMariaDB());
        // System.out.println("Connexion réussi !");
        // checkConnection(new ConnectorMariaDB());

        Connector connectorTest = new ConnectorMariaDB();
        Connection connectTest = ConnectionBDD.getInstance(connectorTest);
        DAOBatiment daoBatiment = new DAOBatiment(connectTest);
        Batiment batimentTest = daoBatiment.selectById(1);

        System.out.println(batimentTest);
    }

}
