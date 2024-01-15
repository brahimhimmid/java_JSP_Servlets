package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import modele.DonneesNonValidesException;
import modele.FacadeGestionUtilisateurImpl;
import modele.FacadeGestionUtilisateurs;
import modele.PseudoDejaExistantException;
//declarer un listener
@WebListener

public class InitialisationFacade implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        FacadeGestionUtilisateurs facadeGestionUtilisateurs = new FacadeGestionUtilisateurImpl();
        sce.getServletContext().setAttribute("facade", facadeGestionUtilisateurs);
        try {
            facadeGestionUtilisateurs.inscription("brahim", "1234");
            facadeGestionUtilisateurs.inscription("himmid", "12");
        } catch (PseudoDejaExistantException e) {
            e.printStackTrace();
        } catch (DonneesNonValidesException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
