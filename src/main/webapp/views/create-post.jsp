<%--
  Created by IntelliJ IDEA.
  User: caomi
  Date: 10/19/2023
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Post</title>
    <%@include file="commons/resources.jsp" %>
</head>

<body>

<%@include file="commons/header.jsp"%>

<div class="container justify-content-md-center" style="width: 50vw; padding-top: 5vh; padding-top: max(10vh);">

    <form method="post" enctype="multipart/form-data">
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input name="title" type="title" id="title" class="form-control"/>
            <label class="form-label" for="title">Title</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input name="description" type="description" id="description" class="form-control"/>
            <label class="form-label" for="description">Description</label>
        </div>

        <div class="mb-4 form-outline">
            <textarea name="content" type="content" id="content" class="form-control"></textarea>
            <label class="form-label" for="description">Content</label>
        </div>

        <div class="input-group mb-3">
            <input type="file" name="file" class="form-control" id="file">
            <label class="input-group-text" for="file">Upload</label>
        </div>
        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Post</button>

    </form>
</div>

<%@include file="commons/footer.jsp"%>
</body>
</html>
