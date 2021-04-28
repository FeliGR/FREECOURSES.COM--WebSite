<%-- 
    Document   : Header
    Created on : Apr 14, 2021, 4:29:52 PM
    Author     : felig
--%>

<%@page import="FreeCourses.logic.User"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<% User user=  (User) session.getAttribute("user");  %>
<!DOCTYPE html>
<header>
    <div>
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark ">
            <div class="container-fluid">
                <a class="navbar-brand" href="../home/show">FREECOURSES.COM</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/home/show">Home</a>
                        </li>
                        <% if(user == null){%>
                        <li class="nav-item">
                            <a class="nav-link active" href="/FreeCourses/presentation/login/show">Log in</a>
                        </li>
                        <% } %>
                    	<% if(user != null){%>
                        <%if(user.getType()== 1){%>
                        <li class="nav-item">                           
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/student/history/show">History</a>                            
                        </li>
                        <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/login/logout">Log out</a>
                        </li>
                        <% } %>
                        <%if(user.getType()== 2) {%>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/professor/sections/show">Sections</a>
                        </li>
                        <li class="nav-item">                           
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/login/logout">Log out</a>
                        </li>
                        <% } %>
                        <%if(user.getType()== 3) {%>
                        <li class="nav-item">                         
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/administrator/courses/show">Admin Courses</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/administrator/professors/show">Admin Professors</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/FreeCourses/presentation/login/logout">Log out</a>
                        </li>
                        
                        <% } %>
                        
                    <% } %>
                   </ul>        
                </div>
            </div>
        </nav>
    </div>
</header>

