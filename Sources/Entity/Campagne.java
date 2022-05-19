package Entity;

public class Campagne {

    private int id;
    private String message;
    private String type;
    private String titre;
    private String date;

    public Campagne(int id, String message, String type, String titre, String date) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.titre = titre;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
