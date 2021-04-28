/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerSection;

import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author alonso
 * @author felig
 * @author joela
 */
@WebServlet(name = "RegisterSectionController", urlPatterns = {"/presentation/administrator/registerSection/show", "/presentation/administrator/registerSection/register"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrator/registerSection/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrator/registerSection/register":
                viewUrl = this.register(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String register(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validate(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.registerAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/administrator/RegisterSections.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    Map<String, String> validate(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("sectionSchedule").isEmpty()) {
            errores.put("sectionSchedule", "Schedule required");
        }
        if (request.getParameter("courseId").isEmpty()) {
            errores.put("courseId", "Course Id required");
        }
        if (request.getParameter("sectionProfessorId").isEmpty()) {
            errores.put("sectionProfessorId", "Professor Id required");
        }

        return errores;

    }

    public void updateModel(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");

        Service domainService = Service.instance();
        
            model.getCurrent().setSchedule(request.getParameter("sectionSchedule"));
            model.getCurrent().setCourse(domainService.findCourseById(Integer.parseInt(request.getParameter("courseId"))));
            model.getCurrent().setProfessor(domainService.findProfessorById(request.getParameter("sectionProfessorId")));
        
    }

    public String registerAction(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        Section section = new Section(request.getParameter("sectionSchedule"), domainService.findCourseById(Integer.parseInt(request.getParameter("courseId"))),
                domainService.findProfessorById(request.getParameter("sectionProfessorId")));

        domainService.saveSection(section);

        model.setCurrent(section);

        return "/presentation/administrator/sections/show";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setSchedule("");
        model.getCurrent().setCourse(null);
        model.getCurrent().setProfessor(null);
        return "/presentation/administrator/RegisterSections.jsp";
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
