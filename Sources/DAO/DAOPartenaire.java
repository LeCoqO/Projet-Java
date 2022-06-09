package DAO;

import Entity.Partenaire;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPartenaire extends DAObis<Partenaire> {

    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOPartenaire(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Partenaire à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Partenaire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into partenaire values('"
                    + obj.getId() + " , '"
                    + obj.getNom() + "' , '"
                    + obj.getPrenom() + "' , '"
                    + obj.getAge() + "' , '"
                    + obj.getTel() + "' , '"
                    + obj.getMail() + "' , '"
                    + obj.getAdresse() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un partenaire de la base à partir d'un objet Partenaire
     *
     * @param obj un objet Partenaire à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Partenaire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from partenaire where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Partenaire à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Partenaire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update partenaire set"
                    + "NomPartenaire='" + obj.getNom() + "' , "
                    + "PrenomPartenaire='" + obj.getPrenom() + "' "
                    + "AgePartenaire='" + obj.getAge() + "' , "
                    + "TelPartenaire='" + obj.getTel() + "' , "
                    + "MailPartenaire='" + obj.getMail() + "' , "
                    + "AdressePartenaire='" + obj.getAdresse() + "' , "
                    + "where IdPartenaire =" + obj.getId() + ")");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Partenaire
     */
    @Override
    public Partenaire selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from partenaire where id=" + id);
            res.next();
            return new Partenaire(res.getInt("IdPartenaire"),
                    res.getString("NomPartenaire"),
                    res.getString("PrenomPartenaire"),
                    res.getInt("AgePartenaire"),
                    res.getString("TelPartenaire"),
                    res.getString("MailPartenaire"),
                    res.getString("AdressePartenaire"));
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Méthode de recherche des informations par le nom du partenaire
     *
     * @param name correspond au nom du partenaire
     * @return un objet Partenaire
     */
    @Override
    public Partenaire selectByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from partenaire where nom='" + name + "'");
            res.next();
            return new Partenaire(res.getInt("IdPartenaire"),
                    res.getString("NomPartenaire"),
                    res.getString("PrenomPartenaire"),
                    res.getInt("AgePartenaire"),
                    res.getString("TelPartenaire"),
                    res.getString("MailPartenaire"),
                    res.getString("AdressePartenaire"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Partenaire> getAll() {

        List<Partenaire> allPartenaire = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from partenaire");
            while (res.next()) {
                allPartenaire.add(new Partenaire(res.getInt("IdPartenaire"),
                        res.getString("NomPartenaire"),
                        res.getString("PrenomPartenaire"),
                        res.getInt("AgePartenaire"),
                        res.getString("TelPartenaire"),
                        res.getString("MailPartenaire"),
                        res.getString("AdressePartenaire")));
            }
        } catch (SQLException ex) {
            return allPartenaire;
        }
        return allPartenaire;
    }

}