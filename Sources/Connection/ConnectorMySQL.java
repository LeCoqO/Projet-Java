package Connection;

/**
 * Implémentation de la classe Connector pour une connection à la base
 */
public class ConnectorMySQL extends Connector {

    /**
     * Constructeur du connecteur
     */
    public ConnectorMySQL() {
        super("jdbc:mysql://localhost:3306/cnam_dao", "root", "root", "projet_java");
    }

}
