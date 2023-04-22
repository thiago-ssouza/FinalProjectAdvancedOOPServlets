<%--
  Created by IntelliJ IDEA.
  User: Thiago
  Date: 22/04/2023
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="index.jsp">Final Project Servlet</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="user-register.jsp">Register User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="user-update.jsp">Update User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="user-delete.jsp">Delete User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="display-users.jsp">List User</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
