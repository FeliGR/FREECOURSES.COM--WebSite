/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.professors;

import FreeCourses.logic.Service;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alonso
 */
@WebServlet(name = "AdminProfessorsController", urlPatterns = {"/presentation/administrator/professors/show", "/presentation/administrator/professors/search"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new FreeCourses.presentation.administrator.professors.Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrator/professors/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrator/professors/search":
                viewUrl = this.search(request);
                break;

        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();
        try {
            model.setProfessors(domainService.findAllProfessors());
            return "/presentation/administrator/Professors.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
    }

        public String search(HttpServletRequest request) {
        return this.searchAction(request);
    }

    public String searchAction(HttpServletRequest request) {
        String searchTerm = request.getParameter("searchProfesor").toUpperCase();
        
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();
        
        try {
            model.setProfessors(domainService.findAllProfessors().stream().filter(profesor ->
                    profesor.getName().contains(searchTerm)).collect(Collectors.toList()));
            return "/presentation/administrator/Professors.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
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
