package Entity;

public class Locataire {

    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String categoriePro;
    private String mail;
    private int idAppart; //Clé étrangère

    public Locataire(int id, String nom, String prenom, int age, String adresse, String categoriePro, String mail, int idAppart) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.categoriePro = categoriePro;
        this.mail = mail;
        this.idAppart = idAppart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCategoriePro() {
        return categoriePro;
    }

    public void setCategoriePro(String categoriePro) {
        this.categoriePro = categoriePro;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdAppart() {
        return idAppart;
    }

    public void setIdAppart(int idAppart) {
        this.idAppart = idAppart;
    }
    
    
}
