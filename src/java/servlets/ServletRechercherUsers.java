package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(name = "RechercherUtilisateurs", urlPatterns = {"/RechercherUtilisateurs"})
public class ServletRechercherUsers extends HttpServlet {

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
        
        
        String  login = (String) request.getParameter("login");
        
         String forwardTo = "rechercher-utilisateur.jsp";
        
        if (login != null) {
            Utilisateur u = gestionnaireUtilisateurs.getUtilisateurByLogin(login);
            ArrayList<Utilisateur> liste = new ArrayList();
            
            if (u!=null)
                liste.add(u);
            else
                request.setAttribute("messageErreur", "L'utilisateur " + login + " n'existe pas.");
            
            request.setAttribute("listeDesUsers", liste);
            request.setAttribute("offset", 0);
            request.setAttribute("totalUtilisateur", 1);
            
            forwardTo = "afficher-utilisateurs.jsp";
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
