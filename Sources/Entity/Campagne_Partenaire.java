package Entity;

public class Campagne_Partenaire {

    private int idCampagne;
    private int idPartenaire;

    public Campagne_Partenaire(int idCampagne, int idPartenaire) {
        this.idCampagne = idCampagne;
        this.idPartenaire = idPartenaire;
    }

    public int getIdCampagne() {
        return idCampagne;
    }

    public void setIdCampagne(int idCampagne) {
        this.idCampagne = idCampagne;
    }

    public int getIdPartenaire() {
        return idPartenaire;
    }

    public void setIdPartenaire(int idPartenaire) {
        this.idPartenaire = idPartenaire;
    }

}
