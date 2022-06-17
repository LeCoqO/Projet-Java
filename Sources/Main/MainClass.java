package Main;

import DAO.*;
import Entity.*;
import Connection.ConnectionBDD;
import Connection.Connector;
import Connection.ConnectorMySQL;
import java.sql.*;
import java.util.ArrayList;
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
        System.out.println("ok");
        DAOBatiment bat7 = new DAOBatiment(connection);
        System.out.println("ok2");
        List<Batiment> le_tieks = bat7.getAll();
        System.out.println("ok3");
        for (Batiment batiment : le_tieks) {
            System.out.println(batiment);

        }
    }

}
