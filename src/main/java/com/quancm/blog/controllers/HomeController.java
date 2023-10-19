package com.quancm.blog.controllers;

import com.quancm.blog.daos.PostDao;
import com.quancm.blog.models.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/home", "/"})
public class HomeController extends HttpServlet {
    private Post latestPost;
    private final PostDao postDao = new PostDao();

    @Override
    public void init() throws ServletException {
        latestPost = postDao.getPostById(1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("username") != null) {
//            request.setAttribute("display", "none");
//            request.setAttribute("action", "logout");
//            request.setAttribute("status", "Logout");
//            request.setAttribute("createPost", "create-post");
//
//        } else {
//            request.setAttribute("action", "sign-up");
//            request.setAttribute("status", "Sign up");
//            request.setAttribute("createPostDisplay", "none");
//        }
        HeaderRefactor.checkLogin(request, response);

        request.getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
    }
}