package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Locataire;

public class DAOLocataire extends DAO<Locataire> {

    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOLocataire(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Locataire à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Locataire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into locataire values('"
                    + obj.getId() + " , '"
                    + obj.getNom() + "' , '"
                    + obj.getPrenom() + "' , '"
                    + obj.getAge() + "' , '"
                    + obj.getTel() + "' , '"
                    + obj.getMail() + "' , '"
                    + obj.getCategoriePro() + "' , '"
                    + obj.getIdAppart() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un locataire de la base à partir d'un objet Locataire
     *
     * @param obj un objet Locataire à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Locataire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from locataire where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Locataire à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Locataire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update locataire set"
                    + "NomLocataire='" + obj.getNom() + "' , "
                    + "PrenomLocataire='" + obj.getPrenom() + "' "
                    + "AgeLocataire='" + obj.getAge() + "' , "
                    + "TelLocataire='" + obj.getTel() + "' , "
                    + "MailLocataire='" + obj.getMail() + "' , "
                    + "CatProfessionnel='" + obj.getCategoriePro() + "' , "
                    + "IdAppart='" + obj.getIdAppart() + "' , "
                    + "where IdLocataire =" + obj.getId() + ")");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Locataire
     */
    @Override
    public Locataire selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from locataire where id=" + id);
            res.next();
            return new Locataire(res.getInt("IdLocataire"),
                    res.getString("NomLocataire"),
                    res.getString("PrenomLocataire"),
                    res.getInt("AgeLocataire"),
                    res.getString("TelLocataire"),
                    res.getString("MailLocataire"),
                    res.getString("CatProfessionnel"),
                    res.getInt("IdAppart"));
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Méthode de recherche des informations par le nom du locataire
     *
     * @param name correspond au nom du locataire
     * @return un objet Locataire
     */
    public Locataire selectByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from locataire where nom='" + name + "'");
            res.next();
            return new Locataire(res.getInt("IdLocataire"),
                    res.getString("NomLocataire"),
                    res.getString("PrenomLocataire"),
                    res.getInt("AgeLocataire"),
                    res.getString("TelLocataire"),
                    res.getString("MailLocataire"),
                    res.getString("CatProfessionnel"),
                    res.getInt("IdAppart"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Locataire> getAll() {

        List<Locataire> allLocataire = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from locataire");
            while (res.next()) {
                allLocataire.add(new Locataire(
                        res.getInt("IdLocataire"),
                        res.getString("NomLocataire"),
                        res.getString("PrenomLocataire"),
                        res.getInt("AgeLocataire"),
                        res.getString("TelLocataire"),
                        res.getString("MailLocataire"),
                        res.getString("CatProfessionnel"),
                        res.getInt("IdAppart")));
            }
        } catch (SQLException ex) {
            return allLocataire;
        }
        return allLocataire;
    }

    public int getNombreLoca(int idLocataire) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT COUNT(*) AS nbLoca FROM locataire WHERE IdLocataire = "+idLocataire);
            res.next();
            return res.getInt("nbLoca");
        } catch (SQLException ex) {
            return -1;
        }
    }

}
