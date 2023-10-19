package com.quancm.blog.controllers;

import com.quancm.blog.daos.PostDao;
import com.quancm.blog.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostController", urlPatterns = "/post")
public class PostController extends HttpServlet {

    private final PostDao postDao = new PostDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NumberFormatException  {

        int postId = Integer.parseInt(request.getParameter("postId"));
        Post post = postDao.getPostById(postId);

        if (post != null) {
            request.setAttribute("imageSource", post.getImageUrl());
            request.setAttribute("username", post.getAuthor());
            request.setAttribute("title", post.getTitle());
            request.setAttribute("content", post.getContent());
            request.setAttribute("timeStamp", post.getCreatedAt());
        }
        HeaderRefactor.checkLogin(request, response);
        request.getRequestDispatcher("views/commons/post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}