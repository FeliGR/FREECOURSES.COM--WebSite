<%-- 
    Document   : Index
    Created on : Apr 14, 2021, 4:30:10 PM
    Author     : felig
--%>
<%@page import="FreeCourses.logic.Course"%>
<%@page import="FreeCourses.logic.Student"%>
<%@page import="FreeCourses.logic.Enrollment"%>
<%@page import="FreeCourses.logic.Section"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="FreeCourses.presentation.home.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Student student = null;
    Model model = (Model) request.getAttribute("model");
    List<Course> courses = model.getCourses();
    if (request.getSession(true).getAttribute("student") != null) {
        student = (Student) request.getAttribute("student");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Home | FREECOURSES.COM</title>  
    </head>
    <body>
        <div class="container my-1">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4 fw-bold">Courses List</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <form action="/FreeCourses/presentation/home/search" method="POST">
                        <div class="input-group py-3">
                            <input type="text" name="searchCourse" class="form-control" placeholder="Search courses">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>    
                    <!-- List group-->
                    <ul class="list-group shadow">
                        <% for (Course course : courses) {%>
                        <% if (course.isStatus() || (request != null && request.getParameter("searchCourse") != null && !request.getParameter("searchCourse").isEmpty())) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-1">
                                <div class="media-body order-2 order-lg-1 align-items-lg-center">  
                                    <img class="float-start img-course" src='/FreeCourses/presentation/home/image?imageId=<%=course.getId()%>'>
                                    <h5 class="mt-0 mb-1 font-weight-bold mb-2"> <%=course.getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small">Thematic: <%=course.getThematic()%> </p>
                                    <p class="font-italic text-muted mb-0 small">Price: <%=course.getPrice()%> $</p>
                                    <% if (course.isStatus()) {%>
                                    <p class="font-italic text-muted mb-0 small"> On Sale </p>
                                    <% } else { %>
                                    <p class="font-italic text-muted mb-0 small"> NOT On Sale: Normal Price </p>
                                    <% } %>
                                    <div class="position-absolute top-50 end-0 translate-middle-y p-3">
                                        <a href=<% if (request.getSession(true).getAttribute("student") != null) {%>
                                           "/FreeCourses/presentation/sections/show?courseId=<%=course.getId()%>"
                                           <% } else { %> "/FreeCourses/presentation/login/show"<% }%>>
                                            <button type="button" class="btn btn-primary">View Sections</button>
                                        </a>
                                    </div>

                                </div> <!-- End -->
                        </li> <!-- End -->
                        <% } %> 
                        <% }%>
                    </ul> <!-- End -->
                    <figure class="text-center pt-5 ">
                        <blockquote class="blockquote text-light fw-light">
                            <p>An investment in knowledge pays the best interest.</p>
                        </blockquote>
                        <figcaption class="blockquote-footer text-light">
                            Benjamin Franklin
                        </figcaption>
                    </figure>
                </div>
            </div>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
