package Main;

import DAO.*;
import Entity.*;
import Connection.ConnectionBDD;
import Connection.Connector;
import Connection.ConnectorMySQL;
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
        Employe employetest = new Employe(1, "Mauchand", "Coco", "coco123", "123", "Administrateur");
        // Employe employeCoco = daoEmploye.create(emplyetest);
        daoEmploye.create(employetest);

        System.out.println(employetest);
    }

}
