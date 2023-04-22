<%@ page import="java.util.List" %>
<%@ page import="com.college.lasalle.advancedoop.finalprj.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thiago
  Date: 21/04/2023
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Display all Users</title>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sticky-footer-navbar/">

  <!-- Bootstrap core CSS -->
  <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="sticky-footer-navbar.css" rel="stylesheet">
  <style>
    body > .container {
      padding: 60px 15px 0;
    }

    .footer {
      position: absolute;
      bottom: 0;
      width: 100%;
      height: 60px;
      line-height: 60px;
      background-color: #f5f5f5;
    }
  </style>

  <script>

    function verifyMessage(){
      // Retrieve the error message from the request object
      let message = null;
      message = '${pageContext.request.getAttribute("message")}';

      // alert(typeof message)
      // alert(message.length)
      // Check if error message exists and display as pop-up message
      if (message !== null && message !== "" && typeof message !== "undefined" && message.length > 0 && message != "null") {
        alert(message);
      }
      message = null;
    }

  </script>

</head>
<body onload="verifyMessage()">

  <jsp:include page="header.jsp"/>

    <div class="container">
    <h1>User List</h1>
    <form method="post" action="${pageContext.request.contextPath}/user">
      <c:set var="servletParam" value="list" /> <!-- Set the value of the variable 'servletParam' -->
      <input type="hidden" name="servletParam" value="${servletParam}" />
      <input class="btn btn-primary" type="submit" value="List Users"/>
    </form>
    <table class="table table-bordered table-hover container">
      <thead>
      <tr>
        <th colspan="7">User Information</th>
        <th colspan="6">User Address</th>
      </tr>
      <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Age</th>
        <th>Phone Number</th>
        <th>Street Number</th>
        <th>Street Name</th>
        <th>City</th>
        <th>State/Province</th>
        <th>Country</th>
        <th>Postal Code</th>
      </tr>
      </thead>
      <tbody>
          <%-- Retrieve the list from request attributes --%>
          <c:forEach items="${userList}" var="item">
            <tr>
              <td>${item.getUserId()}</td>
              <td>${item.getFirstName()}</td>
              <td>${item.getLastName()}</td>
              <td>${item.getUsername()}</td>
              <td>${item.getEmail()}</td>
              <td>${item.getAge()}</td>
              <td>${item.getPhoneNumber()}</td>
              <td>${item.getAddress().getStreetNumber()}</td>
              <td>${item.getAddress().getStreetName()}</td>
              <td>${item.getAddress().getCity()}</td>
              <td>${item.getAddress().getStateProvince()}</td>
              <td>${item.getAddress().getCountry()}</td>
              <td>${item.getAddress().getPostalCode()}</td>

            </tr>
          </c:forEach>
<%--          <c:if test="${empty userList}">--%>
<%--            <tr>--%>
<%--              <td colspan="1">No items found.</td>--%>
<%--            </tr>--%>
<%--          </c:if>--%>
      </tbody>
    </table>
    </div>
  <jsp:include page="footer.jsp"/>

</body>
</html>
