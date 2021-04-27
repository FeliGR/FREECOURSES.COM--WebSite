<%-- 
    Document   : Enrollments
    Created on : Apr 26, 2021, 11:42:57 PM
    Author     : felig
--%>

<%@page import="FreeCourses.logic.Enrollment"%>
<%@page import="java.util.List"%>
<%@page import="FreeCourses.presentation.professor.enrollments.Model"%>
<%@page import="FreeCourses.logic.Professor"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Enrollment> enrollments = model.getSection().getEnrollmentsList();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Professor Section's Enrollments | FREECOURSES.COM</title>  
    </head>
    <body>

        <div class="container py-5">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4">Sections List</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <!-- List group-->
                    <ul class="list-group shadow">
                        <% for (Enrollment enrollment : enrollments) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                <div class="media-body order-2 order-lg-1">
                                    <h5 class="mt-0 font-weight-bold mb-2"> <%= enrollment.getSection().getCourse().getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small">Group number: <%=enrollment.getSection().getId()%> </p>
                                    <p class="font-italic text-muted mb-0 small"> <%=enrollment.getSection().getSchedule()%> </p>                                   
                                    <div>
                                        <form action="FreeCourses/presentation/professor/sections/enrollments/update"" method="POST">
                                            <div class="input-group py-3">
                                                <input type="text" name="finalGrade" value=<%=enrollment.getGrade()%> class="form-control" placeholder="Final grade">
                                                <div class="input-group-append">
                                                    <button class="btn btn-primary" type="submit" >
                                                        Update grade
                                                    </button>
                                                </div>
                                            </div>
                                        </form> 
                                    </div>                                                  
                                </div> <!-- End -->
                        </li> <!-- End --> 
                        <% }%>
                    </ul> <!-- End -->
                </div>
            </div>

        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
