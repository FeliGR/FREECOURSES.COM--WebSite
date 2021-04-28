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
        <title>Log in | FREECOURSES.COM</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <% Model model = (Model) request.getAttribute("model"); %>
        <% Map<String, String> errors = (Map<String, String>) request.getAttribute("errors"); %>
        <% Map<String, String[]> form = (errors == null) ? this.getForm(model) : request.getParameterMap();%>
        <div class="container text-center">
            <div class="row px-3">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="img-left d-none d-md-flex"></div>
                    <div class="card-body">
                        <h4 class="title text-center mt-4">
                            Login into account
                        </h4>
                        <form class="form-box px-3" action="/FreeCourses/presentation/login/login" method="post">
                            <div class="form-input">
                                <span><i class="fa fa-id-card" ></i></span>
                                <input class="<%=erroneo("userId", errors)%>" type="text" name="userId" placeholder="ID" value="<%=form.get("userId")[0]%>" title="<%=title("userId", errors)%>" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input class="<%=erroneo("userPsw", errors)%>" type="password" name="userPsw" placeholder="Password" value="<%=form.get("userPsw")[0]%>" title="<%=title("userPsw", errors)%>" tabindex="10" required>
                            </div>
                            <div class="mb-3 text-center">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Login
                                </button>
                            </div>
                            <div class="text-center mb-2">
                                Don't have an account?
                                <a href="/FreeCourses/presentation/signup/show" class="register-link">
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
    private String erroneo(String campo, Map<String, String> errors) {
        if ((errors != null) && (errors.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errors) {
        if ((errors != null) && (errors.get(campo) != null)) {
            return errors.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<String, String[]>();
        values.put("userId", new String[]{model.getCurrent().getId()});
        values.put("userPsw", new String[]{model.getCurrent().getPassword()});
        return values;
    }
%>

