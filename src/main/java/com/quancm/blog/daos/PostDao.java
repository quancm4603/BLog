package com.quancm.blog.daos;

import com.quancm.blog.models.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/blog";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    // Database connection
    private Connection connection;


    public PostDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Thêm một bài viết mới
    public boolean addPost(Post post) {
        String sql = "INSERT INTO posts (title, description, content, author, image_url) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getContent());
            statement.setString(4, post.getAuthor());
            statement.setString(5, post.getImageUrl());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Lấy danh sách tất cả bài viết
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("title"));
                post.setDescription(resultSet.getString("description"));
                post.setContent(resultSet.getString("content"));
                post.setAuthor(resultSet.getString("author"));
                post.setImageUrl(resultSet.getString("image_url"));
                post.setCreatedAt(resultSet.getTimestamp("created_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Post getPostById(int id){
        Post post = null;
        String sql = "SELECT * FROM posts where post_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                post = new Post();
                post.setTitle(resultSet.getString("title"));
                post.setDescription(resultSet.getString("description"));
                post.setContent(resultSet.getString("content"));
                post.setAuthor(resultSet.getString("author"));
                post.setImageUrl(resultSet.getString("image_url"));
                post.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }


}
