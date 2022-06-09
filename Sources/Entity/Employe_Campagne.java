package Entity;

public class Employe_Campagne {

    private int idCampagne;
    private int idEmploye;
    private boolean autorisation;

    public Employe_Campagne(int idCampagne, int idEmploye, boolean autorisation) {
        this.idCampagne = idCampagne;
        this.idEmploye = idEmploye;
        this.autorisation = autorisation;
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

    public boolean isAutorisation() {
        return autorisation;
    }

    public void setAutorisation(boolean autorisation) {
        this.autorisation = autorisation;
    }

}
