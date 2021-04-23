<%-- 
    Document   : Index
    Created on : Apr 14, 2021, 4:30:10 PM
    Author     : felig
--%>
<%@page import="FreeCourses.logic.Course"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="FreeCourses.presentation.home.Model"%>
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
        <title>Home | FREECOURSES.COM</title>  
    </head>
    <body>
        <div class="container my-1">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4">Courses List</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <form action="/FreeCourses/presentation/home/serch" method="POST">
                        <div class="input-group py-3">
                            <input type="text" name="serchCourse" class="form-control" placeholder="Search courses">
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
                        <% if (course.isStatus()) {%>
                        <li class="list-group-item">
                            <!-- Custom content-->
                            <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                <div class="media-body order-2 order-lg-1">
                                    <h5 class="mt-0 font-weight-bold mb-2"> <%=course.getName()%> </h5>
                                    <p class="font-italic text-muted mb-0 small"> <%=course.getThematic()%> </p>

                                    <p class="font-italic text-muted mb-0 small"> On Sale </p>

                                    <div class="position-absolute top-50 end-0 translate-middle-y p-3">
                                        <a href="/FreeCourses/presentation/sections/show?courseId=<%=course.getId()%>"><button type="button" class="btn btn-primary">View Sections</button></a><%--href="/FreeCourses/presentation/section/show?courseId=<%=course.getId()%>"  --%>
                                    </div>
                                    <%--</div><img src="https://i.imgur.com/KFojDGa.jpg" alt="Generic placeholder image" width="200" class="ml-lg-5 order-1 order-lg-2">--%>

                                </div> <!-- End -->
                        </li> <!-- End -->
                        <% } %> 
                        <% }%>
                    </ul> <!-- End -->
                </div>
            </div>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>