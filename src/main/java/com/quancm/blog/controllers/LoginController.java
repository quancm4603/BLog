package com.quancm.blog.controllers;

import com.quancm.blog.daos.UserDao;
import com.quancm.blog.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null){
            response.sendRedirect("./");
        }else {
            request.getServletContext().getRequestDispatcher("/views/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            if (userDao.validate(user)){
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                response.sendRedirect("./");
            }else {
                request.getServletContext().getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}