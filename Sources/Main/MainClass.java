package Main;

import Connection.ConnectionBDD;
import Connection.Connector;
import Connection.ConnectorMySQL;
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

        Connection connection = ConnectionBDD.getInstance(new ConnectorMySQL());
        System.out.println("Connexion réussi !");
        checkConnection(new ConnectorMySQL());
    }

}
