<%@ page import="java.util.List" %>
<%@ page import="com.quancm.blog.models.Post" %>
<%@ page import="com.quancm.blog.daos.PostDao" %>
<div class="container">
    <div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 align-items-center justify-content-center">
        <a href="./${createPost}">
            <button type="button" class="btn btn-primary" style="display: ${createPostDisplay}">${createPost}</button>
        </a>
    </div>
</div>
<div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 align-items-center justify-content-center">
    <div class="list-group">
        <%
            PostDao postDao = new PostDao();
            for (Post post : postDao.getAllPosts()){
        %>
        <a href="./post?postId=<%=post.getPostId()%>" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
            <img src="<%=post.getImageUrl()%>" alt="thumbnail" width="32" height="32" class="rounded-circle flex-shrink-0">
            <div class="d-flex gap-2 w-100 justify-content-between">
                <div>
                    <h6 class="mb-0"><%=post.getTitle()%></h6>
                    <p class="mb-0 opacity-75"><%=post.getDescription()%></p>
                </div>
                <small class="opacity-50 text-nowrap"><%=post.getCreatedAt()%></small>
            </div>
        </a>
        <%
            }
        %>

    </div>
</div>