package fr.iat.cinema;

public class Film {

    int id;
    String titre;
    String afficheNom;
    double note;

    public Film(int id, String titre, String afficheNom, double note) {
        this.id = id;
        this.titre = titre;
        this.afficheNom = afficheNom;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAfficheNom() {
        return afficheNom;
    }

    public void setAfficheNom(String afficheNom) {
        this.afficheNom = afficheNom;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    //    @Override
//    public boolean equals(Object obj) {
//        return ((Film)obj).id==this.id;
//    }
}