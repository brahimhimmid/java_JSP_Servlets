package modele;

import java.util.*;

public class FacadeGestionUtilisateurImpl implements FacadeGestionUtilisateurs {

    private Map<String, Utilisateur> inscrits;
    private Map<String, Utilisateur> connectes;


    public FacadeGestionUtilisateurImpl() {

        inscrits = new HashMap<>();
        connectes = new HashMap<>();
    }

    @Override
    public void inscription(String pseudo, String motDePasse) throws
            PseudoDejaExistantException, DonneesNonValidesException {

        if (Objects.isNull(pseudo) || Objects.isNull(motDePasse) || pseudo.isBlank() || motDePasse.isBlank()) {
            throw new DonneesNonValidesException();
        }

        if (inscrits.containsKey(pseudo)) {
            throw new PseudoDejaExistantException();
        }

        Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
        inscrits.put(pseudo, utilisateur);


    }

    @Override
    public String connexion(String pseudo, String motPasse) throws IdentifiantsNonValideException, UtilisateurDejaConnecteException {
        if (Objects.isNull(pseudo) || Objects.isNull(motPasse) || pseudo.isBlank() || motPasse.isBlank()) {
            throw new IdentifiantsNonValideException();
        }

        if (!inscrits.containsKey(pseudo) || !inscrits.get(pseudo).checkMotDePasse(motPasse)) {
            throw new IdentifiantsNonValideException();

        }

        Utilisateur utilisateur = this.inscrits.get(pseudo);

        if (connectes.containsValue(utilisateur)) {
            throw new UtilisateurDejaConnecteException();
        }

        String cle = UUID.randomUUID().toString();
        connectes.put(cle, utilisateur);
        return cle;
    }

    @Override
    public void deconnexion(String cle) throws CleInexistanteException {
        if (!connectes.containsKey(cle)){
            throw  new CleInexistanteException();
        }
        this.connectes.remove(cle);

    }

    @Override
    public Utilisateur getUtilisateurParCle(String cle)throws CleInexistanteException {
        if (!connectes.containsKey(cle)){
            throw new CleInexistanteException();
        }

        return connectes.get(cle);


    }

    @Override
    public Collection<Utilisateur> getTousUtilisateurs(String cle) throws CleInexistanteException {
        if (!connectes.containsKey(cle)){
            throw  new CleInexistanteException();
        }
        return  this.inscrits.values();
    }
}
