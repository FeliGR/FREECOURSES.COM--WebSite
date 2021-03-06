/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.courses;

import FreeCourses.logic.Course;
import FreeCourses.logic.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alonso
 */
@WebServlet(name = "AdminCoursesController", urlPatterns = {"/presentation/administrator/courses/show", "/presentation/administrator/courses/search", "/presentation/administrator/courses/changeStatus"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrator/courses/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrator/courses/search":
                viewUrl = this.search(request);
                break;
            case "/presentation/administrator/courses/changeStatus":
                viewUrl = this.updateStatus(request);
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
            model.setCourses(domainService.findAllCourses());
            return "/presentation/administrator/Courses.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
    }

    public String search(HttpServletRequest request) {
        return this.searchAction(request);
    }

    public String searchAction(HttpServletRequest request) {
        String searchTerm = request.getParameter("searchCourse").toUpperCase();

        Model model = (Model) request.getAttribute("model");
        Service domainService = Service.instance();

        try {
            List<Course> coursesList = domainService.findAllCourses();
            List<Course> searchedCourses = new ArrayList<>();

            for (Course course : coursesList) {
                String toSearch = course.getName() + course.getThematic();
                if (toSearch.toUpperCase().contains(searchTerm)) {
                    searchedCourses.add(course);
                }
            }
            model.setCourses(searchedCourses);
            return "/presentation/administrator/Courses.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
    }

    private String updateStatus(HttpServletRequest request) {
        try {
            Model model = (Model) request.getAttribute("model");
            Service domainService = Service.instance();
            Course course = domainService.findCourseById(Integer.parseInt(request.getParameter("courseId")));
            course.setStatus(!course.isStatus());
            domainService.updateCourse(course);
            model.setCourses(domainService.findAllCourses());

            return "/presentation/administrator/Courses.jsp";
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
