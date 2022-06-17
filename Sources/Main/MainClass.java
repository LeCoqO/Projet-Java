package Main;

import Connection.*;
import DAO.*;
import Entity.*;

import java.sql.*;

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
