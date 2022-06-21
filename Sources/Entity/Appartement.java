package Entity;

public class Appartement {

    private int id;
    private String categorie;
    private int numero;
    private int idBatiment; // Clé étrangère

    public Appartement(int id, String categorie, int numero, int idBatiment) {
        this.id = id;
        this.categorie = categorie;
        this.numero = numero;
        this.idBatiment = idBatiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

}
