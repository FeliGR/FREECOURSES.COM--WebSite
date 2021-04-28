<%-- 
    Document   : RegisterCourses
    Created on : Apr 27, 2021, 10:01:56 PM
    Author     : joela
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Register Course | FREECOURSES.COM</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class="container text-center">
            <div class="row px-3">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="img-left d-none d-md-flex"></div>
                    <div class="card-body">
                        <h4 class="title text-center mt-4">
                            Create Course
                        </h4>
                        <form class="form-box px-3" action="/FreeCourses/presentation/administrator/registerCourse/register" method="post">
                            <div class="form-input">
                                <span><i class="fa fa-book" aria-hidden="true"></i></span>
                                <input type="text" name="courseName" placeholder="Name" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-bookmark" aria-hidden="true"></i></span>
                                <input type="text" name="courseThematic" placeholder="Thematic" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-money" aria-hidden="true"></i></span>
                                <input type="text" name="coursePrice" placeholder="Price" tabindex="10" required>
                            </div>
                            <div class="custom-file text-start py-3">
                                <input type="file" name="image" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
                            </div>
                            <div class="form-check text-start">
                                <input class="form-check-input" name="courseStatus" type="checkbox" value="true" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                    On Sale
                                </label>
                            </div>
                            <div class="mb-3 text-center">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Save
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>