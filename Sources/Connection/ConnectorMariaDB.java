package Connection;

/**
 * Implémentation de la classe Connector pour une connection à la base
 */
public class ConnectorMariaDB extends Connector {

    /**
     * Constructeur du connecteur
     */
    public ConnectorMariaDB() {
        super("jdbc:mariadb://localhost:3306/projet_java", "root", "", "projet_java");
    }

}
