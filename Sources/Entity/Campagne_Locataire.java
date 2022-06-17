package projetjava.Sources.Entity;

public class Campagne_Locataire {

    private int idCampagne;
    private int IdLocataire;

    public Campagne_Locataire(int idCampagne, int idLocataire) {
        this.idCampagne = idCampagne;
        IdLocataire = idLocataire;
    }

    public int getIdCampagne() {
        return idCampagne;
    }

    public void setIdCampagne(int idCampagne) {
        this.idCampagne = idCampagne;
    }

    public int getIdLocataire() {
        return IdLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        IdLocataire = idLocataire;
    }

}
