package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Batiment;

public class DAOBatiment extends DAO<Batiment> {
    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOBatiment(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Batiment à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Batiment obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into batiment values('"
                    + obj.getId() + " , '"
                    + obj.getAdresse() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un bâtiment de la base à partir d'un objet Batiment
     *
     * @param obj un objet Batiment à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Batiment obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from batiment where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Batiment à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Batiment obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update batiment set"
                    + "AdresseBatiment='" + obj.getAdresse() + "' , "
                    + "where IdBatiment =" + obj.getId() + ")");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Batiment
     */
    @Override
    public Batiment selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from batiment where id=" + id);
            res.next();
            return new Batiment(res.getInt("IdBatiment"),
                    res.getString("AdresseBatiment"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Batiment> getAll() {

        List<Batiment> allBatiment = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from batiment");
            while (res.next()) {
                allBatiment.add(new Batiment(res.getInt("IdBatiment"),
                        res.getString("AdresseBatiment")));
            }
        } catch (SQLException ex) {
            return allBatiment;
        }
        return allBatiment;
    }

}
