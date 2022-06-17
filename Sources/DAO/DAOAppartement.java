package DAO;

import Entity.Appartement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAppartement extends DAO<Appartement> {
    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOAppartement(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Appartement à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Appartement obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into appartement values('"
                    + obj.getId() + " , '"
                    + obj.getCategorie() + "' , '"
                    + obj.getNumero() + "' , '"
                    + obj.getIdBatiment() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un appartement de la base à partir d'un objet Appartement
     *
     * @param obj un objet Appartement à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Appartement obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from appartement where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Appartement à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Appartement obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update appartement set"
                    + "CategorieAppart='" + obj.getCategorie() + "' , "
                    + "NumAppart='" + obj.getNumero() + "' "
                    + "IdBatiment='" + obj.getIdBatiment() + "' , "
                    + "where IdAppart =" + obj.getId() + ")");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Appartement
     */
    @Override
    public Appartement selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from appartement where id=" + id);
            res.next();
            return new Appartement(res.getInt("IdAppart"),
                    res.getString("CategorieAppart"),
                    res.getInt("NumAppart"),
                    res.getInt("IdBatiment"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Appartement> getAll() {

        List<Appartement> allAppartement = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from appartement");
            while (res.next()) {
                allAppartement.add(new Appartement(res.getInt("IdAppart"),
                        res.getString("CategorieAppart"),
                        res.getInt("NumAppart"),
                        res.getInt("IdBatiment")));
            }
        } catch (SQLException ex) {
            return allAppartement;
        }
        return allAppartement;
    }

}
