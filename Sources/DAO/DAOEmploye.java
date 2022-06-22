package DAO;

import Entity.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEmploye extends DAO<Employe> {

    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOEmploye(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création d'un enregistrement
     *
     * @param obj un objet Employe à écrire dans la base
     * @return boolean qui vaut true si la création a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean create(Employe obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into employe values('"
                    + obj.getId() + " , '"
                    + obj.getNom() + "' , '"
                    + obj.getPrenom() + "' , '"
                    + obj.getLogin() + "' , '"
                    + obj.getPassword() + "' , '"
                    + obj.getFonction() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean createWoID(Employe obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into employe values("
                    + "NULL" + " , '"
                    + obj.getNom() + "' , '"
                    + obj.getPrenom() + "' , '"
                    + obj.getLogin() + "' , '"
                    + obj.getPassword() + "' , '"
                    + obj.getFonction() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Supprime un employé de la base à partir d'un objet Employe
     *
     * @param obj un objet Employe à supprimer dans la base
     * @return boolean qui vaut true si la suppression a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean delete(Employe obj) {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "delete from employe where IdEmploye=" + obj.getId();
            System.out.println(sql);
            return !statement.execute(sql);
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Méthode de mise à jour d'un enregistrement
     *
     * @param obj un objet Employe à mettre à jour dans la base
     * @return boolean qui vaut true si la mise à jour a réussi, false dans le cas
     *         contraire
     */
    @Override
    public boolean update(Employe obj) {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "update employe set "
                    + "NomEmploye='" + obj.getNom() + "' , "
                    + "PrenomEmploye='" + obj.getPrenom() + "', "
                    + "Login='" + obj.getLogin() + "' , "
                    + "Password='" + obj.getPassword() + "' , "
                    + "Fonction='" + obj.getFonction() + "'"
                    + "where IdEmploye =" + obj.getId() + ";";
            System.out.println(sql);
            return !statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println("marche pas la update de employe | " + ex);
            return false;
        }
    }

    /**
     * Méthode de recherche des informations par l'id
     *
     * @param id l'identificateur à rechercher
     * @return un objet Employe
     */
    @Override
    public Employe selectById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from employe where id=" + id);
            res.next();
            return new Employe(res.getInt("IdEmploye"),
                    res.getString("NomEmploye"),
                    res.getString("PrenomEmploye"),
                    res.getString("Login"),
                    res.getString("Password"),
                    res.getString("Fonction"));
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Méthode de recherche des informations par le nom de l'employé
     *
     * @param name correspond au nom de l'employé
     * @return un objet Employe
     */

    public Employe selectByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from employe where nom='" + name + "'");
            res.next();
            return new Employe(res.getInt("IdEmploye"),
                    res.getString("NomEmploye"),
                    res.getString("PrenomEmploye"),
                    res.getString("Login"),
                    res.getString("Password"),
                    res.getString("Fonction"));
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Employe> getAll() {

        List<Employe> allEmploye = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from employe");
            while (res.next()) {
                allEmploye.add(new Employe(res.getInt("IdEmploye"),
                        res.getString("NomEmploye"),
                        res.getString("PrenomEmploye"),
                        res.getString("Login"),
                        res.getString("Password"),
                        res.getString("Fonction")));
            }
        } catch (SQLException ex) {
            return allEmploye;
        }
        return allEmploye;
    }

}