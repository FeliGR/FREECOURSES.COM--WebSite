/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.student.history;

import FreeCourses.logic.Enrollment;
import FreeCourses.logic.Service;
import FreeCourses.logic.Student;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author joela
 * @author felig
 * @author alonsoc
 */
@WebServlet(name = "StudentHistoryController", urlPatterns = {"/presentation/student/history/show", "/presentation/student/history/print"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/student/history/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/student/history/print":
                viewUrl = this.print(request);
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
            Student student = (Student) request.getSession(true).getAttribute("student");
            model.setCurrent(domainService.findStudentById(student.getId()));
            return "/presentation/student/history/View.jsp";
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

    public String print(HttpServletRequest request) {
        return this.printAction(request);
    }

    public String printAction(HttpServletRequest request) {
        String dest = "C:\\Users\\alonso\\Desktop";
        Date date = new Date();
        Student studentdb;
        List<Enrollment> history;
        Document document = new Document();
        Service domainService = FreeCourses.logic.Service.instance();
        try {
            Student student = (Student) request.getSession(true).getAttribute("student");
            studentdb = domainService.findStudentById(student.getId());
            history = studentdb.getEnrollmentsList();
            File file = new File("C:\\Users\\alonso\\Desktop\\" + "HISTORY" + studentdb.getId() + ".pdf");
            FileOutputStream out = new FileOutputStream(file);
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("STUDENT HISTORY" + "\n"));
            document.add(new Paragraph(date.toString() + "\n"));
            document.add(new Paragraph("Student: " + studentdb.getName() + "\n" + "Id: " + studentdb.getId() + "\n" + "\n"));
            for (Enrollment enrollment : history) {

                document.add(new Paragraph("Course: " + enrollment.getSection().getCourse().getName() + "\n"
                        + "Section number: " + enrollment.getSection().getId() + "\n"
                        + "Schedule: " + enrollment.getSection().getSchedule() + "\n"
                        + "Final Grade: " + enrollment.getGrade() + "\n" + "\n"));
            }
            System.out.println("Created successfully ");
            document.close();
            writer.close();
            return "/presentation/home/show";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }

    }
}
