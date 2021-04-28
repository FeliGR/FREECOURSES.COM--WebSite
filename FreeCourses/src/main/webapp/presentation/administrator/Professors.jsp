<%-- 
    Document   : Professors
    Created on : Apr 27, 2021, 4:00:36 PM
    Author     : alonso
--%>
<%@page import="java.util.List"%>
<%@page import="FreeCourses.presentation.administrator.professors.Model"%>
<%@page import="FreeCourses.logic.Professor"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Professor> professors = model.getProfessors();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Professor list | FREECOURSES.COM</title>  
    </head>
    <body>

        <div class="container py-5">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4">Professor List</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <form action="/FreeCourses/presentation/administrator/professors/search" method="POST">
                        <div class="input-group py-3">
                            <input type="text" name="searchProfesor" class="form-control" placeholder="Search profesor">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>    
                    <!-- List group-->
                    <ul class="list-group shadow">
                        <% for (Professor professor : professors) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                <div class="media-body order-2 order-lg-1">
                                    <h5 class="mt-0 font-weight-bold mb-2"><%= professor.getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small">Id: <%=professor.getId()%> </p>
                                    <p class="font-italic text-muted mb-0 small">Email: <%=professor.getEmail()%> </p>
                                    <p class="font-italic text-muted mb-0 small">Phone: <%=professor.getPhone()%> </p>
                                    <p class="font-italic text-muted mb-0 small">Specialty: <%=professor.getSpecialty()%> </p>                                                
                                </div> <!-- End -->
                        </li> <!-- End --> 
                        <% }%>
                    </ul> <!-- End -->
                </div>
            </div>
            <div class="text-center py-4">
                <a href="/FreeCourses/presentation/administrator/registerProfessor/show"> <button type="button" class="btn btn-success">Add Professor</button></a>
            </div>  
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>