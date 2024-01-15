package modele;

public interface FacadeGestionUtilisateurs {

    void inscription(String  pseudo , String motDePasse) throws
            PseudoDejaExistantException,DonneesNonValidesException;

    String connexion(String pseudo, String  motPasse) throws
            IdentifiantsNonValideException,UtilisateurDejaConnecteException;


    void  deconnexion(String cle) throws  CleInexistanteException;

    Utilisateur getUtilisateurParCle(String cle) throws CleInexistanteException;


}
