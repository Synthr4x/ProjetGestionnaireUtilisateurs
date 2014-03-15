/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaire.GestionnaireUtilisateurs;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Christian
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers", "/"})
public class ServletUsers extends HttpServlet {

    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");
        String forwardTo = "";

        String login = null, nom = null, prenom = null;

        nom = (String) request.getParameter("nom");
        prenom = (String) request.getParameter("prenom");
        login = (String) request.getParameter("login");

        if (action != null) {
            if (action.equals("listerLesUtilisateurs")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "afficher-utilisateurs.jsp";
                
            } else if (action.equals("creerUtilisateursDeTest")) {
                gestionnaireUtilisateurs.creerUtilisateursDeTest();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                request.setAttribute("messages", liste.size() + " nouveaux utilisateurs crées.");
                forwardTo = "AfficherUtilisateurs";
                
            } else if (action.equals("creerUnUtilisateur")) {
                if (login != null) {
                    gestionnaireUtilisateurs.creeUtilisateur(nom, prenom, login);
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                    request.setAttribute("listeDesUsers", liste);
                }

                forwardTo = "creer-utilisateurs.jsp";

            } else if (action.equals("chercherParLogin")) {
                if (login != null) {
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUtilisateurByLogin(login);
                    request.setAttribute("listeDesUsers", liste);
                }

                forwardTo = "afficher-detail-utilisateur.jsp";

            } else if (action.equals("updateUtilisateur")) {

                if (login != null) {
                    gestionnaireUtilisateurs.majUtilisateur(login, nom, prenom);

                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                    request.setAttribute("listeDesUsers", liste);
                }
                forwardTo = "updateUtilisateur";

            } else {
                // TODO à changer vers index.jsp
                forwardTo = "afficher-utilisateurs.jsp";
            }
        } else {
            // TODO à changer vers index.jsp
            forwardTo = "afficher-utilisateurs.jsp";
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
        // Après un forward, plus rien ne peut être exécuté après !  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
