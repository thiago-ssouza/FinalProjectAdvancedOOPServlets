<%--
  Created by IntelliJ IDEA.
  User: Thiago
  Date: 21/04/2023
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>User Registration</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

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

      <div class="container register-form">
      <form action="${pageContext.request.getContextPath()}/user" method="post">
        <div class="note">
          <h1>User Registration</h1>
        </div>
        <div class="form-content">
          <div class="form-row">
            <div class="col-md-4 mb-3">
              <label for="firstName">First name</label>
              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" required>
            </div>
            <div class="col-md-4 mb-3">
              <label for="lastName">Last name</label>
              <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name" required>
            </div>
            <div class="col-md-4 mb-3">
              <label for="username">Username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
            </div>
          </div>
        </div>
        <div class="form-row">
          <div class="col-md-6 mb-3">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email@email.com" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="age">Age</label>
            <input type="number" class="form-control" id="age" name="age" placeholder="Age" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="phoneNumber">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" required>
          </div>
        </div>
        <div class="form-row">
          <div class="col-md-6 mb-3">
            <label for="streetNumber">Street Number</label>
            <input type="number" class="form-control" id="streetNumber" name="streetNumber" placeholder="Street Number" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="streetName">Street Name</label>
            <input type="text" class="form-control" id="streetName" name="streetName" placeholder="Street Name" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" placeholder="City" required>
          </div>
        </div>
        <div class="form-row">
          <div class="col-md-6 mb-3">
            <label for="stateProvince">State/Province</label>
            <input type="text" class="form-control" id="stateProvince" name="stateProvince" placeholder="State/Province" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="country">Country</label>
            <input type="text" class="form-control" id="country" name="country" placeholder="Country" required>
          </div>
          <div class="col-md-3 mb-3">
            <label for="postalCode">Postal Code</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Postal Code" required>
          </div>
        </div>
        <c:set var="servletParam" value="register" /> <!-- Set the value of the variable 'servletParam' -->
        <input type="hidden" name="servletParam" value="${servletParam}" />
        <input class="btn btn-primary" type="submit"/>
        <input class="btn btn-primary" type="reset"/>
      </form>
    </div>
  <jsp:include page="footer.jsp"/>

</body>
</html>
