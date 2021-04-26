<%-- 
    Document   : Password
    Created on : 25/04/2021, 03:05:19 PM
    Author     : joela
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <%@ include file="/presentation/Header.jsp" %>
        <title>Password | FREECOURSES.COM</title>  
    </head>
    <body>
        
        <div class="container">
            <div class="row text-center text-white mb-1">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4">User's New Password: <%=request.getAttribute("password")%></h1>
                </div>
            </div>
        </div>

        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
