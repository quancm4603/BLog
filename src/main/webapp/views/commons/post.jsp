<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-4">
    <div class="row">
        <img src="${imageSource}">
        <h5 class="card-title">${username}</h5>
        <h6 class="card-title">${title}</h6>
        <p class="card-text">${content}</p>
        <p class="card-text"><small class="text-muted">${timeStamp}</small></p>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
