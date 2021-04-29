/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.home;

import FreeCourses.logic.Course;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CoursesController", urlPatterns = {"/presentation/home/show", "/presentation/home/search", "/presentation/home/image"})

public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/home/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/home/search":
                viewUrl = this.search(request);
                break;
            case "/presentation/home/image":
                viewUrl = this.image(request, response);
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        FreeCourses.logic.Service domainService = FreeCourses.logic.Service.instance();
        try {
            model.setCourses(domainService.findAllCourses());
            return "/presentation/Index.jsp";
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
        FreeCourses.logic.Service domainService = FreeCourses.logic.Service.instance();

        try {
            List<Course> coursesList = domainService.findAllCourses();
            List<Course> searchedCourses = new ArrayList<>();

            for (Course course : coursesList) {
                String toSearch = course.getName()+course.getThematic() ;
                if (toSearch.toUpperCase().contains(searchTerm)) {
                    searchedCourses.add(course);
                }
            }
            model.setCourses(searchedCourses);

            return "/presentation/Index.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
    }

    private String image(HttpServletRequest request, HttpServletResponse response) {
        String imageId = request.getParameter("imageId");
        Path path = FileSystems.getDefault().getPath("C:/freeCoursesImages", imageId);
        try (OutputStream out = response.getOutputStream()) {
            Files.copy(path, out);
            out.flush();
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
        return null;
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
