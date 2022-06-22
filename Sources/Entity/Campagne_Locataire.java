package Entity;

public class Campagne_Locataire {

    private int idCampagne;
    private int idLocataire;

    public Campagne_Locataire(int idCampagne, int idLocataire) {
        this.idCampagne = idCampagne;
        this.idLocataire = idLocataire;
    }

    public int getIdCampagne() {
        return idCampagne;
    }

    public void setIdCampagne(int idCampagne) {
        this.idCampagne = idCampagne;
    }

    public int getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        this.idLocataire = idLocataire;
    }

}
