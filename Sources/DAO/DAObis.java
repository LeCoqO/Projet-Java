package projetjava.Sources.DAO;

import java.sql.Connection;

/**
 * Classe abstraite générique Permet de déclarer des objets d'accès à une base
 * de données
 *
 * @author Hervé Martinez
 * @param <T> Représente la classe des objets Java à manipuler
 */
public abstract class DAObis<T> extends DAO<T>{

    /**
     * champ connection
     */
    protected Connection connection;

    /**
     * Constructeur
     *
     * @param connection permet l'initialisation du champ connection
     */
    public DAObis(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de recherche des informations par un nom
     *
     * @param name
     * @return T
     */
    public abstract T selectByName(String name);
}
