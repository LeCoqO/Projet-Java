package DAO;

import Entity.Personne;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonne extends DAO<Personne> {

    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOPersonne(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Personne à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas contraire
     */
    @Override
    public boolean create(Personne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into personne values('"
                    + obj.getId() + " , '"
                    + obj.getLogin() + "' , '"
                    + obj.getPassword() + "')"
            );
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un Personne de la base à partir d'un objet Personne
     *
     * @param obj un objet Personne à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas contraire
     */
    @Override
    public boolean delete(Personne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from personne where id=" + obj.getId());
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Personne à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas contraire
     */
    @Override
    public boolean update(Personne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update personne set"
                    + "Login='" + obj.getLogin() + "' , "
                    + "Password='" + obj.getPassword() + "' "
                    + "where id=" + obj.getId() + ")"
            );
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Personne
     */
    @Override
    public Personne selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from Personne where id=" + id);
            res.next();
            return new Personne(res.getInt("IdPersonne"),
                    res.getString("NomPersonne"),
                    res.getString("PrenomPersonne"),
                    res.getInt("AgePersonne"),
                    res.getString("AdressePersonne"),
                    res.getString("CatProfessionnel"),
                    res.getString("MailPersonne"),
                    res.getInt("IdAppart")
            );

        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Méthode de recherche des informations par le nom du Personne
     *
     * @param name correspond au nom du Personne
     * @return un objet Personne
     */
    @Override
    public Personne selectByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from Personne where nom='" + name + "'");
            res.next();
            return new Personne(res.getInt("IdPersonne"),
                    res.getString("NomPersonne"),
                    res.getString("PrenomPersonne"),
                    res.getInt("AgePersonne"),
                    res.getString("AdressePersonne"),
                    res.getString("CatProfessionnel"),
                    res.getString("MailPersonne"),
                    res.getInt("IdAppart")
            );
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Personne> getAll() {

        List<Personne> allPersonne = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from Personne");
            while (res.next()) {
                allPersonne.add(new Personne(
                        res.getInt("IdPersonne"),
                        res.getString("NomPersonne"),
                        res.getString("PrenomPersonne"),
                        res.getInt("AgePersonne"),
                        res.getString("AdressePersonne"),
                        res.getString("CatProfessionnel"),
                        res.getString("MailPersonne"),
                        res.getInt("IdAppart"))
                );
            }
        } catch (SQLException ex) {
            return allPersonne;
        }
        return allPersonne;
    }
}
