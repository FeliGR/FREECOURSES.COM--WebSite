<%-- 
    Document   : View
    Created on : Apr 26, 2021, 10:26:00 PM
    Author     : felig
--%>

<%@page import="FreeCourses.logic.Section"%>
<%@page import="java.util.List"%>
<%@page import="FreeCourses.presentation.professor.sections.Model"%>
<%@page import="FreeCourses.logic.Professor"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Section> sections = model.getCurrent().getSectionsList();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Professor Sections | FREECOURSES.COM</title>  
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
                        <% for (Section section : sections) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                <div class="media-body order-2 order-lg-1">
                                    <h5 class="mt-0 font-weight-bold mb-2"> <%=section.getCourse().getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small"> <%=section.getSchedule()%> </p>
                                    <p class="font-italic text-muted mb-0 small"> Group: <%=section.getId()%> </p>
                                    <div class="position-absolute top-50 end-0 translate-middle-y p-3">
                                        <a href="/FreeCourses/presentation/professor/sections/enrollments/show?sectionId=<%=section.getId()%>"><button type="button" class="btn btn-success">View Students</button></a>
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