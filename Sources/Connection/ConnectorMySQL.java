package Connection;

/**
 * Implémentation de la classe Connector pour une connection à la base
 */
public class ConnectorMySQL extends Connector {

    /**
     * Constructeur du connecteur
     */
    public ConnectorMySQL() {
        super("jdbc:mysql://localhost/projet_java", "root", "", "projet_java");
    }

}
