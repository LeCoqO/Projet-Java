package Entity;

public class Partenaire {

    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String tel;
    private String mail;
    private String adresse;

    public Partenaire(int id, String nom, String prenom, int age, String tel, String mail, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
        this.mail = mail;
        this.adresse = adresse;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
