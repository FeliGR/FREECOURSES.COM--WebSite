<%-- 
    Document   : Login
    Created on : 14/04/2021, 10:00:40 PM
    Author     : joela
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="FreeCourses.presentation.login.Model"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        

        <meta http-equiv="Content-Type" content="text/html; charset="utf-8">
        <title>Login Form</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, shrink-to-fit=no">


    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        <div class="container text-center">
            <div class="row px-3">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="img-left d-none d-md-flex"></div>

                    <div class="card-body">
                        <h4 class="title text-center mt-4">
                            Login into account
                        </h4>
                        <form class="form-box px-3">
                            <div class="form-input">
                                <span><i class="fa fa-id-card" ></i></span>
                                <input type="text" name="userId" placeholder="ID" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input type="password" name="userPsw" placeholder="Password" required>
                            </div>

                            <div class="mb-3 text-center">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Login
                                </button>
                            </div>

                            <div class="text-center mb-2">
                                Don't have an account?
                                <a href="#" class="register-link">
                                    Register here
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
    
    
</html>
<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("claveFld", new String[]{model.getCurrent().getClave()});
       return values;
    }
    
%> 
