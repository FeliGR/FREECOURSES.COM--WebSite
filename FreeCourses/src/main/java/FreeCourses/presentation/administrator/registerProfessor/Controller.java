/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerProfessor;

import FreeCourses.logic.Professor;
import FreeCourses.logic.Service;
import FreeCourses.logic.Student;
import FreeCourses.logic.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alonso
 */
@WebServlet(name = "RegisterProfessorController", urlPatterns = {"/presentation/administrator/registerProfessor/show", "/presentation/administrator/registerProfessor/save"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new FreeCourses.presentation.administrator.registerProfessor.Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrator/registerProfessor/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrator/registerProfessor/save":
                viewUrl = this.save(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String save(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validate(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.saveAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/administator/RegisterProfessor.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    Map<String, String> validate(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("userId").isEmpty()) {
            errores.put("userId", "Id required");
        }
        if (request.getParameter("userPassword").isEmpty()) {
            errores.put("userPassword", "Password required");
        }
        if (request.getParameter("userFullName").isEmpty()) {
            errores.put("userFullName", "FullName required");
        }
        if (request.getParameter("userEmail").isEmpty()) {
            errores.put("userEmail", "Email required");
        }
        if (request.getParameter("userPhone").isEmpty()) {
            errores.put("userPhone", "Phone required");
        }
        if (request.getParameter("userSpecialty").isEmpty()) {
            errores.put("userSpecialty", "Specialty required");
        }
        
        return errores;

    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setEmail(request.getParameter("userEmail"));
        model.getCurrent().setName(request.getParameter("userFullName"));
        model.getCurrent().setPhone(request.getParameter("userSpecialty"));
        model.getCurrent().setPhone(request.getParameter("userPhone"));       
        model.getUser().setId(request.getParameter("userId"));
        model.getUser().setPassword(request.getParameter("userPassword"));
        model.getUser().setType(2);
    }

    public String saveAction(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        User user = new User(request.getParameter("userId"), request.getParameter("userPassword"), 2);

        Professor professor = new Professor(request.getParameter("userId"),request.getParameter("userFullName"),request.getParameter("userPhone"),
                request.getParameter("userSpecialty"),request.getParameter("userEmail"));


        domainService.saveProfessor(professor);
        domainService.saveUser(user);
        model.setCurrent(professor);
        model.setUser(user);

        return "/presentation/administrator/professors/show";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {        
        Model model = (Model) request.getAttribute("model");
        
        model.getCurrent().setSpecialty("");
        model.getCurrent().setId("");
        model.getCurrent().setName("");
        model.getCurrent().setEmail("");
        model.getCurrent().setPhone("");
        model.getUser().setPassword("");
        return "/presentation/administrator/RegisterProfessor.jsp";
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
