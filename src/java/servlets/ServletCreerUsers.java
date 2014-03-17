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
 * @author Jokho
 */
@WebServlet(name = "CreerUtilisateurs", urlPatterns = {"/CreerUtilisateurs"})
public class ServletCreerUsers extends HttpServlet {

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

        String action = request.getParameter("action");

        String forwardTo = "";

        if (action != null) {
            if (action.equals("creerUtilisateursDeTest")) {
                gestionnaireUtilisateurs.creerUtilisateursDeTest();
                request.setAttribute("message", "Plein de nouveaux utilisateurs crées.");
                forwardTo = "AfficherUtilisateurs";

            } else if (action.equals("creerUnUtilisateur")) {
                String nom = (String) request.getParameter("nom");
                String prenom = (String) request.getParameter("prenom");
                String login = (String) request.getParameter("login");
                String mdp = (String) request.getParameter("mdp");

                if (login != null && mdp != null && nom != null && prenom != null) {
                    gestionnaireUtilisateurs.creeUtilisateur(nom, prenom, login, mdp);
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                    request.setAttribute("listeDesUsers", liste);
                    request.setAttribute("message", "Nouvel utilisateur <b>" + login + "</b> créé.");

                    forwardTo = "AfficherUtilisateurs";
                }
                else{
                    request.setAttribute("messageErreur", "Information incomplètes !");
                    forwardTo = "creer-utilisateur.jsp";
                }
            } else {
                forwardTo = "creer-utilisateur.jsp";
            }
        } else {
            forwardTo = "creer-utilisateur.jsp";
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);

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
