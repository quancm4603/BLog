<%--
  Created by IntelliJ IDEA.
  User: caomi
  Date: 10/16/2023
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="commons/resources.jsp" %>
</head>
<body>
<div class="container justify-content-md-center" style="width: 50vw; padding-top: 5vh; padding-top: max(10vh);">

    <form method="post">
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input name="username" type="username" id="username" class="form-control"/>
            <label class="form-label" for="username">username</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input name="password" type="password" id="password" class="form-control"/>
            <label class="form-label" for="password">Password</label>
        </div>

        <div class="mb-3 form-check">
            <input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember me</label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

        <!-- Register buttons -->
        <div class="text-center">
            <p>Not a member? <a href="#!">Register</a></p>
        </div>
    </form>
</div>
</body>
</html>
