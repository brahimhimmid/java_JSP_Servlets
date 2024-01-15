package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.*;

import java.io.IOException;

@WebServlet(name = "controleur", urlPatterns = "/authentification/*")
public class Controleur extends HttpServlet {

    private static final String HOME = "home";
    private static final String CONNEXION = "connexion";
    private static final String DECONNEXION = "deconnexion";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] parties = uri.split("/");
        String cleNavigation = parties[parties.length - 1];
        String destination = "/WEB-INF/pages/accueil.jsp";
        FacadeGestionUtilisateurs facade = (FacadeGestionUtilisateurs) this.getServletContext().getAttribute("facade");


        if (HOME.equals(cleNavigation)) {
            destination = "/WEB-INF/pages/accueil.jsp";

        }
        if (DECONNEXION.equals(cleNavigation)) {
            String cle = (String) req.getSession().getAttribute("cleAuthentification");
            try {
                facade.deconnexion(cle);
                //vider les information d'une session
                req.getSession().invalidate();

            } catch (CleInexistanteException e) {
                String erreur = "erreur inatendu liee a la cle d'authentification";
                req.setAttribute("erreur", erreur);

            }


            destination = "/WEB-INF/pages/accueil.jsp";

        }
        this.getServletContext().getRequestDispatcher(destination).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] parties = uri.split("/");
        String cleNavigation = parties[parties.length - 1];
        String destination = "/WEB-INF/pages/accueil.jsp";

        FacadeGestionUtilisateurs facade = (FacadeGestionUtilisateurs) this.getServletContext().getAttribute("facade");


        if (CONNEXION.equals(cleNavigation)) {
            String pseudo = req.getParameter("pseudo");
            String password = req.getParameter("password");
            try {
                String cle = facade.connexion(pseudo, password);
                Utilisateur utilisateur = facade.getUtilisateurParCle(cle);
                req.getSession().setAttribute("user", utilisateur);
                req.getSession().setAttribute("cleAuthentification", cle);
                req.setAttribute("utilisateurs",facade.getTousUtilisateurs(cle));
                destination = "/WEB-INF/pages/menu.jsp";

            } catch (IdentifiantsNonValideException e) {
                String erreur = "identifiant non valide";
                destination = "/WEB-INF/pages/accueil.jsp";
                req.setAttribute("erreur", erreur);

            } catch (UtilisateurDejaConnecteException e) {
                String erreur = "utilisateur " + pseudo + " est deja connecte";
                destination = "/WEB-INF/pages/accueil.jsp";
                req.setAttribute("erreur", erreur);


            } catch (CleInexistanteException e) {
                String erreur = "erreur inattendu liee a la cle d'authentification ";
                destination = "/WEB-INF/pages/accueil.jsp";
                req.setAttribute("erreur", erreur);


            }


        }
        this.getServletContext().getRequestDispatcher(destination).forward(req, resp);

    }
}

