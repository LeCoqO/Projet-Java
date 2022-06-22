package DAO;

import Entity.EmployeCampagne;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEmployeCampagne extends DAO<EmployeCampagne> {
    /**
     * Constructeur d'un objet d'accès à la base
     *
     * @param connection un objet connection de java.sql
     */
    public DAOEmployeCampagne(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(EmployeCampagne obj) {
        System.out.println("insert into ass_employe_campagne values('"
                + obj.getIdCampagne() + "' , '"
                + obj.getIdEmploye() + "' , '"
                + Boolean.compare(obj.isDroitCampagne(), false) + "')");
        try {
            Statement statement = this.connection.createStatement();
            System.out.println("marche");
            boolean value = statement.execute("insert into ass_employe_campagne values('"
                    + obj.getIdCampagne() + "'' , '"
                    + obj.getIdEmploye() + "' , '"
                    + Boolean.compare(obj.isDroitCampagne(), false) + "')");
            System.out.println(value);
            return !value;
        } catch (SQLException ex) {
            System.out.println("marchepa");
            return false;
        }
    }

    @Override
    public boolean delete(EmployeCampagne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("delete from ass_employe_campagne where IdCampagne = "
                    + obj.getIdCampagne() + " AND IdEmploye = "
                    + obj.getIdEmploye() + ";");
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(EmployeCampagne obj) {
        try {
            Statement statement = this.connection.createStatement();
            return !statement.execute("update ass_employe_campagne set"
                    + "DroitCampagne='" + Boolean.compare(obj.isDroitCampagne(), false) + "'WHERE "
                    + "IdEmploye='" + obj.getIdEmploye() + " AND "
                    + "IdCampagne='" + obj.getIdCampagne() + "')");
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public EmployeCampagne selectById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public EmployeCampagne selectById(int idCampagne, int idEmploye) {
        try {
            Statement statement = this.connection.createStatement();
            System.out.println("Select * from employe where IdCampagne = "
                    + idCampagne + " AND IdEmploye = "
                    + idEmploye + ";");
            ResultSet res = statement.executeQuery("Select * from ass_employe_campagne where IdCampagne = "
                    + idCampagne + " AND IdEmploye = "
                    + idEmploye + ";");
            res.next();
            return new EmployeCampagne(res.getInt("IdCampagne"),
                    res.getInt("IdCampagne"),
                    (res.getInt("IdCampagne") == 1));

        } catch (

        SQLException ex) {
            return null;
        }
    }

    @Override
    public List<EmployeCampagne> getAll() {
        List<EmployeCampagne> allEmployeCampagnes = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from ass_employe_campagne");
            while (res.next()) {
                allEmployeCampagnes.add(new EmployeCampagne(res.getInt("IdCampagne"),
                        res.getInt("IdCampagne"),
                        (res.getInt("IdCampagne") == 1)));
            }
        } catch (SQLException ex) {
            return allEmployeCampagnes;
        }
        return allEmployeCampagnes;
    }

}
