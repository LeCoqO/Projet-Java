package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Campagne;

public class DAOCampagne extends DAObis<Campagne> {
    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOCampagne(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Campagne à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Campagne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into campagne values('"
                    + obj.getId() + " , '"
                    + obj.getMessage() + "' , '"
                    + obj.getType() + "' , '"
                    + obj.getTitre() + "' , '"
                    + obj.getDate() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime une campagne de la base à partir d'un objet Campagne
     *
     * @param obj un objet Campagne à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Campagne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from campagne where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Campagne à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Campagne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update campagne set"
                    + "MessageCampagne='" + obj.getMessage() + "' , "
                    + "TypeCampagne='" + obj.getType() + "' "
                    + "TitreCampagne='" + obj.getTitre() + "' , "
                    + "DateCampagne='" + obj.getDate() + "' , "
                    + "where IdCampagne =" + obj.getId() + ")");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Campagne
     */
    @Override
    public Campagne selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from campagne where id=" + id);
            res.next();
            return new Campagne(res.getInt("IdCampagne"),
                    res.getString("MessageCampagne"),
                    res.getString("TypeCampagne"),
                    res.getString("TitreCampagne"),
                    res.getString("DateCampagne"));
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Méthode de recherche des informations par le nom de la campagne
     *
     * @param name correspond au nom de la campagne
     * @return un objet Campagne
     */
    @Override
    public Campagne selectByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from campagne where nom='" + name + "'");
            res.next();
            return new Campagne(res.getInt("IdCampagne"),
                    res.getString("MessageCampagne"),
                    res.getString("TypeCampagne"),
                    res.getString("TitreCampagne"),
                    res.getString("DateCampagne"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Campagne> getAll() {

        List<Campagne> allCampagne = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from campagne");
            while (res.next()) {
                allCampagne.add(new Campagne(res.getInt("IdCampagne"),
                        res.getString("MessageCampagne"),
                        res.getString("TypeCampagne"),
                        res.getString("TitreCampagne"),
                        res.getString("DateCampagne")));
            }
        } catch (SQLException ex) {
            return allCampagne;
        }
        return allCampagne;
    }

}
