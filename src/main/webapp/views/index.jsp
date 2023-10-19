<%--
  Created by IntelliJ IDEA.
  User: caomi
  Date: 10/16/2023
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog</title>
    <%@include file="commons/resources.jsp"%>
</head>
<body>
    <%@include file="commons/header.jsp"%>


    <div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 align-items-center justify-content-center">
        <div class="list-group">
            <%@include file="commons/post-thumnail.jsp"%>
        </div>
    </div>

    <%@include file="commons/footer.jsp"%>
</body>
</html>
