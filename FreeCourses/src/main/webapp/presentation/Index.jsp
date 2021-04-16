<%-- 
    Document   : Index
    Created on : Apr 14, 2021, 4:30:10 PM
    Author     : felig
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="FreeCourses.presentation.home.Model"%>
<%@page import="java.util.List"%>
<%@page import="FreeCourses.Course;"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Course> courses = model.getCourses();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>Cursos Libres</title>  
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="container justify-content-center">
            <div class="row">
                <div class="col-md-8">
                    <div class="input-group mb-3"> <input type="text" class="form-control input-text" placeholder="Search courses...." aria-label="Recipient's username" aria-describedby="basic-addon2">
                        <div class="input-group-append"> <button class="btn btn-outline-primary btn-lg" type="button"><i class="fa fa-search"></i></button> </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                    <div class="card card-body">
                        <div class="media align-items-center align-items-lg-start text-center text-lg-left flex-column flex-lg-row">
                            <div class="mr-2 mb-3 mb-lg-0"> <img class ="img-english_course" width="150" height="150" alt=""> </div>
                            <div class="media-body">
                                <h6 class="media-title font-weight-semibold">Business english 01</h6>                                
                                <p class="mb-3">This course will prepare you for business english(oral and grammar)</p>
                            </div>
                            <div class="mt-3 mt-lg-0 ml-lg-3 text-center">
                                <h3 class="mb-0 font-weight-semibold">ON SALE</h3>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/presentation/Footer.jsp" %>
</body>
</html>