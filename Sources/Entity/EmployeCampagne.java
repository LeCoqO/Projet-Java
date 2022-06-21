package Entity;

public class EmployeCampagne {

    private int idCampagne;
    private int idEmploye;
    private boolean droitCampagne;

    public EmployeCampagne(int idCampagne, int idEmploye, boolean droitCampagne) {
        this.idCampagne = idCampagne;
        this.idEmploye = idEmploye;
        this.droitCampagne = droitCampagne;
    }

    public int getIdCampagne() {
        return idCampagne;
    }

    public void setIdCampagne(int idCampagne) {
        this.idCampagne = idCampagne;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public boolean isDroitCampagne() {
        return droitCampagne;
    }

    public void setDroitCampagne(boolean droitCampagne) {
        this.droitCampagne = droitCampagne;
    }

}
