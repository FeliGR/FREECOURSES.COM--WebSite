<%-- 
    Document   : Login
    Created on : 14/04/2021, 10:00:40 PM
    Author     : joela
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>

        <meta http-equiv="Content-Type" content="text/html; charset="utf-8">
        <title>Login Form</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, shrink-to-fit=no">


    </head>
    <body>
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
                                <input type="password" name="" placeholder="Password" required>
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
