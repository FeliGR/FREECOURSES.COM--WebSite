/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.student.enrollment;

import FreeCourses.logic.Enrollment;
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
 * @author joela
 */
@WebServlet(name = "EnrollmentController", urlPatterns = {"/presentation/student/enrollment"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new FreeCourses.presentation.student.enrollment.Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/student/enrollment":
                viewUrl = this.enroll(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String enroll(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.enrollAction(request);
            } else{
                return "/presentation/home/show";
            }
        } catch (Exception e) {
            System.err.println("error:"+e.getMessage());
            return "/presentation/Error.jsp";
        }
    }
    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("sectionId").isEmpty()) {
            errores.put("sectionId", "Section Required");
        }
        if (request.getSession(true).getAttribute("student") == null) {
            errores.put("student", "Student required");
        }

        return errores;
    }

    void updateModel(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        model.setSection(domainService.findSectionById(Integer.parseInt(request.getParameter("sectionId"))));
        
        model.setStudent((Student)request.getSession(true).getAttribute("student"));

        model.setEnrollment(new Enrollment(model.getSection(), model.getStudent()));
    }

    public String enrollAction(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        domainService.saveEnrollment(model.getEnrollment());
        request.getSession(true).setAttribute("student", domainService.findStudentById(model.getStudent().getId()));

        return "/presentation/student/history/show";
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
