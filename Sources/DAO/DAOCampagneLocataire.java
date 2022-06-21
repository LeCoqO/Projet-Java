package DAO;

import Entity.Campagne_Locataire;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCampagneLocataire extends DAO<Campagne_Locataire> {

    public DAOCampagneLocataire(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Campagne_Locataire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("insert into ass_campagne_locataire values('"
                    + obj.getIdCampagne() + " , '"
                    + obj.getIdLocataire() + "' );");
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean delete(Campagne_Locataire obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from campagne where IdLocataire = "
                    + obj.getIdLocataire() + " AND IdCampagne = "
                    + obj.getIdCampagne() + ";");
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Campagne_Locataire obj) {
        // TODO Auto-generated method stub
        return false;
    }

    public Campagne_Locataire selectById(int idCampagne, int idLocataire) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from employe where IdCampagne = "
                    + idCampagne + " AND IdLocataire = "
                    + idLocataire + ";");
            res.next();
            return new Campagne_Locataire(res.getInt("IdCampagne"),
                    res.getInt("IdCampagne"));

        } catch (

        SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Campagne_Locataire> getAll() {
        List<Campagne_Locataire> allCampagneLocataire = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from employe");
            while (res.next()) {
                allCampagneLocataire.add(new Campagne_Locataire(res.getInt("IdCampagne"),(res.getInt("IdLocataire"))));
            }
        } catch (SQLException ex) {
            return allCampagneLocataire;
        }
        return allCampagneLocataire;
    }

    @Override
    public Campagne_Locataire selectById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    

}