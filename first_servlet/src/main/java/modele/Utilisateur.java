package modele;

public class Utilisateur {

    private  String pseudo;
    private  String motPasse;


    public  Utilisateur(){

    }
    public Utilisateur(String pseudo, String motPasse) {
        this.pseudo = pseudo;
        this.motPasse = motPasse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public  boolean checkMotDePasse(String mdp){
        return  this.motPasse.equals(mdp);
    }
}
