<%-- 
    Document   : View
    Created on : 23/04/2021, 10:38:28 PM
    Author     : joela
--%>
<%@page import="FreeCourses.logic.Student"%>
<%@page import="FreeCourses.logic.Enrollment"%>
<%@page import="java.util.List"%>
<%@page import="FreeCourses.presentation.student.history.Model"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Enrollment> enrollments = model.getCurrent().getEnrollmentsList();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Sections | FREECOURSES.COM</title>  
    </head>
    <body>
        <div class="container py-5">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4 fw-bold">History</h1>
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
                                    <p class="font-italic text-muted mb-0 small"> Final Grade: <%=enrollment.getGrade()%> </p>                                                  
                                </div> <!-- End -->
                        </li> <!-- End --> 
                        <% }%>
                    </ul> <!-- End -->
                </div>
            </div>
            <div class="text-center py-4">
                <a href="/FreeCourses/presentation/student/history/print"> <button type="button" class="btn btn-success">Print to PDF</button></a>
            </div>  
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
