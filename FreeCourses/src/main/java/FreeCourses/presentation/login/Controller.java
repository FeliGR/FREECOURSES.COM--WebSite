/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.login;

import FreeCourses.logic.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joela
 */
@WebServlet(name = "LoginController", urlPatterns = {"/presentation/login/show","/presentation/login/login","/presentation/login/logout"})
public class Controller extends HttpServlet {

  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/login/show":
                viewUrl=this.show(request);
                break;              
            case "/presentation/login/login":
                viewUrl=this.login(request);
                break;            
            case "/presentation/login/logout":
                viewUrl=this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    private String login(HttpServletRequest request) { 
        try{
            Map<String,String> errors =  this.validar(request);
            if(errors.isEmpty()){
                this.updateModel(request);          
                return this.loginAction(request);
            }
            else{
                request.setAttribute("errors", errors);
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }         
    }
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errors = new HashMap<>();
        if (request.getParameter("userId").isEmpty()){
            errors.put("userId","Required Id");
        }

        if (request.getParameter("userPsw").isEmpty()){
            errors.put("userPsw","Required Password");
        }
        return errors;
    }
    
    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setId(request.getParameter("userId"));
        model.getCurrent().setPassword(request.getParameter("userPsw"));
   }

        
    public String loginAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        FreeCourses.logic.Service  domainService = FreeCourses.logic.Service.instance();
        HttpSession session = request.getSession(true);
        try {

            User real = domainService.findUserById(model.getCurrent().getId());
            session.setAttribute("user", real);
            String viewUrl="";
            switch(real.getType()){
                case 1:
                    viewUrl="/presentation/Index.jsp";//viewUrl="/presentation/student";
                    break;
                case 2:
                     viewUrl="/presentarion/Index.jsp";//viewUrl="/presentarion/professor";
                    break;
                case 3:
                    viewUrl="/presentarion/Index.jsp";//viewUrl="/presentarion/admin";
            }
            return viewUrl;
        } catch (Exception ex) {
            Map<String,String> errors = new HashMap<>();
            request.setAttribute("errors", errors);
            errors.put("userId","Incorrect user or password");
            errors.put("userPsw","Incorrect user or password");
            return "/presentation/login/View.jsp"; 
        }        
    }   

    public String logout(HttpServletRequest request){
        return this.logoutAction(request);
    }
    
    public String logoutAction(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.invalidate();
        return "/presentation/Index.jsp";   
    }

    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model= (Model) request.getAttribute("model");
        model.getCurrent().setId("");
        model.getCurrent().setPassword("");
        return "/presentation/login/View.jsp"; 
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
