<%-- 
    Document   : RegisterSections
    Created on : Apr 27, 2021, 10:02:18 PM
    Author     : alonso
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Register Section | FREECOURSES.COM</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="container text-center">
            <div class="row px-3">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="img-left d-none d-md-flex"></div>
                    <div class="card-body">
                        <h4 class="title text-center mt-4">
                            Create Section
                        </h4>
                        <form class="form-box px-3" action="/FreeCourses/presentation/administrator/registerSection/register?courseId=<%= request.getParameter("courseId")%>" method="post">
                            <div class="form-input">
                                <span><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input type="text" name="sectionSchedule" placeholder="Schedule" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
                                <input type="text" name="sectionProfessorId" placeholder="Professor id" tabindex="10" required>
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