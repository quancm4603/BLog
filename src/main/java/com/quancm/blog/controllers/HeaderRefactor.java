package com.quancm.blog.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckLoginController")
public class HeaderRefactor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            request.setAttribute("display", "none");
            request.setAttribute("action", "logout");
            request.setAttribute("status", "Logout");
            request.setAttribute("createPost", "create-post");

        } else {
            request.setAttribute("action", "sign-up");
            request.setAttribute("status", "Sign up");
            request.setAttribute("createPostDisplay", "none");
        }
    }

}