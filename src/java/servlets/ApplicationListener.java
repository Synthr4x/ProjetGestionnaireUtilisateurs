/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import utilisateurs.gestionnaire.GestionnaireUtilisateurs;

/**
 * Web application lifecycle listener.
 *
 * @author Siddi Steven
 */
@WebListener()
public class ApplicationListener implements ServletContextListener {

    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        gestionnaireUtilisateurs.injecterAdministrateur();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
