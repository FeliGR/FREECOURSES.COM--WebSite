/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.professor.enrollments;

import FreeCourses.logic.Enrollment;
import FreeCourses.logic.Professor;
import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import FreeCourses.logic.Student;
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
 * @author felig
 */
@WebServlet(name = "ProfessorController", urlPatterns = {"/presentation/professor/sections/enrollments/show", "/presentation/professor/sections/enrollments/update"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new FreeCourses.presentation.student.enrollment.Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/professor/sections/enrollments/show":
            //viewUrl = this.
            case "/presentation/professor/sections/enrollments/update":
                viewUrl = this.updateGrade(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service domainService = FreeCourses.logic.Service.instance();
        try {

            Section section = (Section) domainService.findSectionById(Integer.parseInt(request.getParameter("sectionId")));
            model.setSection(section);
            return "/presentation/student/history/View.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
    }

    private String updateGrade(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validate(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.updateGradeAction(request);
            } else {
                return "/presentation/home/show";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    Map<String, String> validate(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("sectionId").isEmpty()) {
            errores.put("sectionId", "Section Required");
        }
        if (request.getSession(true).getAttribute("professor") == null) {
            errores.put("professor", "Professor required");
        }
        if (request.getParameter("finalGrade") == null || Integer.parseInt(request.getParameter("finalGrade")) < 0
                || Integer.parseInt(request.getParameter("finalGrade")) > 100) {
            errores.put("finalGrade", "Final Grade out of range");
        }

        return errores;
    }

    void updateModel(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");

        Service domainService = Service.instance();

        model.setSection(domainService.findSectionById(Integer.parseInt(request.getParameter("sectionId"))));

        model.setProfessor((Professor) request.getSession(true).getAttribute("professor"));

        if (request.getParameter("enrollmentId") != null) {
            model.setEnrollment(domainService.findEnrollmentById(Integer.parseInt(request.getParameter("enrollmentId"))));
            Enrollment enrollment = model.getEnrollment();
            enrollment.setGrade(Float.parseFloat(request.getParameter("finalGrade")));
            model.setEnrollment(enrollment);
        }
    }

    public String updateGradeAction(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");

        Service domainService = Service.instance();

        domainService.updateEnrollment(model.getEnrollment());

        request.getSession(true).setAttribute("professor", domainService.findProfessorById(model.getProfessor().getId()));

        return "/presentation/professor/sections/enrollments";
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
