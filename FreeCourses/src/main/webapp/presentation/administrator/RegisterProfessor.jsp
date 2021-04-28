<%-- 
    Document   : RegisterProfessor
    Created on : Apr 27, 2021, 4:47:44 PM
    Author     : alonso
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Register Professor | FREECOURSES.COM</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="container text-center">
            <div class="row px-3">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="img-left d-none d-md-flex"></div>

                    <div class="card-body">
                        <h4 class="title text-center mt-4">
                            Create Professor
                        </h4>
                        <form class="form-box px-3" action="/FreeCourses/presentation/administrator/registerProfessor/save" method="post">
                            <div class="form-input">
                                <span><i class="fa fa-id-card" ></i></span>
                                <input type="text" name="userId" placeholder="ID" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
                                <input type="text" name="userFullName" placeholder="Full name" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input type="password" name="userPassword" placeholder="Password" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
                                <input type="text" name="userSpecialty" placeholder="Specialty" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                                <input type="email" name="userEmail" placeholder="Email" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-phone"></i></span>
                                <input type="tel" name="userPhone" placeholder="Phone" tabindex="10" required>
                            </div>

                            <div class="mb-3 text-center">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Save
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
