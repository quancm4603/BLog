package com.quancm.blog.controllers;

import com.quancm.blog.daos.PostDao;
import com.quancm.blog.models.Post;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CreatePostController", urlPatterns = "/create-post")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class CreatePostController extends HttpServlet {
    private PostDao postDao = new PostDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderRefactor.checkLogin(request, response);
        request.getRequestDispatcher("views/create-post.jsp").forward(request, response);
    }

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String rootPath = getServletContext().getRealPath("/");
        String parentPath = new File(rootPath).getParent();
        parentPath = new File(parentPath).getParent();
        String uploadPath =
                parentPath +
                        File.separator + "src" +
                        File.separator + "main" +
                        File.separator + "webapp"
                        + File.separator + "images"
                        + File.separator + "posts"
                        + File.separator + session.getAttribute("username").toString();

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part filePart = request.getPart("file");
        String fileName = getSubmittedFileName(filePart);

        System.out.println("fileName: " + fileName);
        System.out.println("uploadPath: " + uploadPath);
        // Lưu hình ảnh vào thư mục trên máy chủ
        if (isImageFile(fileName)) {
            String newFileName = generateNewFileName(fileName);
            filePart.write(uploadPath + File.separator + newFileName);
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            String author = session.getAttribute("username").toString();
            String uploadUrl = "images/posts/" + session.getAttribute("username").toString() + "/" + newFileName;
            System.out.println(title);
            System.out.println(description);
            System.out.println(content);



            Post post = new Post();
            post.setTitle(title);
            post.setDescription(description);
            post.setContent(content);
            post.setAuthor(author);
            post.setImageUrl(uploadUrl);
            postDao.addPost(post);
            response.sendRedirect("./");
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tệp không phải là hình ảnh.");
        }

    }

    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        for (String headerPart : header.split(";")) {
            if (headerPart.trim().startsWith("filename")) {
                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String generateNewFileName(String oldFileName) {
        // Ví dụ: Tạo tên mới dựa trên thời gian và UUID
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date(System.currentTimeMillis()));
        String randomUUID = UUID.randomUUID().toString();

        // Kết hợp thời gian và UUID để tạo tên mới
        String newFileName = timestamp + "_" + randomUUID + "_" + oldFileName;

        return newFileName;
    }

    private boolean isImageFile(String fileName) {
        String[] allowedExtensions = {"jpg", "jpeg", "png", "gif"}; // Các định dạng hình ảnh cho phép

        // Lấy phần mở rộng (extension) của tên tệp
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        // Kiểm tra xem phần mở rộng của tệp có trong danh sách định dạng hình ảnh cho phép hay không
        for (String extension : allowedExtensions) {
            if (fileExtension.equals(extension)) {
                return true;
            }
        }

        return false;
    }

}