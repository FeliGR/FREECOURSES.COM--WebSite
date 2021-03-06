<%-- 
    Document   : Courses
    Created on : Apr 27, 2021, 9:40:38 PM
    Author     : alonso
--%>
<%@page import="FreeCourses.logic.Course"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="FreeCourses.presentation.administrator.courses.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Course> courses = model.getCourses();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Course list | FREECOURSES.COM</title>  
    </head>
    <body>
        <div class="container my-1">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4 fw-bold ">Courses List</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <form action="/FreeCourses/presentation/administrator/courses/search" method="POST">
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
                    <ul class="list-group administrator shadow">
                        <% for (Course course : courses) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                <div class="media-body order-2 order-lg-1">
                                    <img class="float-start img-course" src='/FreeCourses/presentation/home/image?imageId=<%=course.getId()%>'>
                                    <h5 class="mt-0 font-weight-bold mb-2"> <%=course.getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small">Thematic: <%=course.getThematic()%> </p>
                                    <p class="font-italic text-muted mb-0 small">Price: <%=course.getPrice()%> </p>
                                    <% if (course.isStatus()) {%>
                                    <p class="font-italic text-muted mb-0 small"> On Sale </p>
                                    <% } else { %>
                                    <p class="font-italic text-muted mb-0 small"> NOT On Sale: Normal Price </p>
                                    <% }%>

                                    <div class="position-absolute top-0 end-0 py-2 px-3">
                                        <a href="/FreeCourses/presentation/administrator/sections/show?courseId=<%=course.getId()%>"><button type="button" class="btn btn-primary">Administrate Sections</button></a>
                                    </div>
                                    <div class="position-absolute bottom-0 end-0 py-2 customButton">
                                        <a href="/FreeCourses/presentation/administrator/courses/changeStatus?courseId=<%=course.getId()%>"><button type="button" class="btn btn-warning">Change Status</button></a>
                                    </div>
                                </div> <!-- End -->
                        </li> <!-- End -->
                        <% }%> 
                    </ul> <!-- End -->
                </div>
            </div>
            <div class="text-center py-4">
                <a href="/FreeCourses/presentation/administrator/registerCourse/show"> <button type="button" class="btn btn-success">Add Course</button></a>
            </div>  
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
