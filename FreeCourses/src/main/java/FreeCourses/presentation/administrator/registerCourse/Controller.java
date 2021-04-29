/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerCourse;

import FreeCourses.logic.Course;
import FreeCourses.logic.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @author alonso
 * @author felig
 * @author joela
 */
@WebServlet(name = "RegisterCourseController", urlPatterns = {"/presentation/administrator/registerCourse/show", "/presentation/administrator/registerCourse/register"})
@MultipartConfig(location="C:/freeCoursesImages")
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrator/registerCourse/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrator/registerCourse/register":
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
                return "/presentation/administrator/RegisterCourses.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    Map<String, String> validate(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("courseName").isEmpty()) {
            errores.put("courseName", "courseName required");
        }
        if (request.getParameter("courseThematic").isEmpty()) {
            errores.put("courseThematic", "Thematic required");
        }
        if (request.getParameter("coursePrice").isEmpty()) {
            errores.put("coursePrice", "Price required");
        }

        return errores;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setName(request.getParameter("courseName"));
        model.getCurrent().setThematic(request.getParameter("courseThematic"));
        model.getCurrent().setPrice(Float.parseFloat(request.getParameter("coursePrice")));
        model.getCurrent().setStatus(Boolean.parseBoolean(request.getParameter("courseStatus")));
    }

    public String registerAction(HttpServletRequest request) throws Exception {
        Part image;
        image = request.getPart("image");
        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        Course course = new Course(request.getParameter("courseName"), request.getParameter("courseThematic"), Float.parseFloat(request.getParameter("coursePrice")));
        course.setStatus(Boolean.parseBoolean(request.getParameter("courseStatus")));
        
        image.write(Integer.toString(domainService.saveCourse(course).getId()));

        model.setCurrent(course);

        return "/presentation/administrator/courses/show";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setName("");
        model.getCurrent().setThematic("");
        model.getCurrent().setPrice(0);
        model.getCurrent().setStatus(false);
        return "/presentation/administrator/RegisterCourses.jsp";
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
