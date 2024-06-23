package com.leomarqz.data;

import com.leomarqz.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBC {
    private static final String SQL_SELECT = "SELECT id,name,lastname,email,phone FROM users";
    private static final String SQL_INSERT = "INSERT INTO users(name,lastname,email,phone) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE users SET name=?,lastname=?,email=?,phone=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM users WHERE id=?";

    public List<User> select()
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        DBConfigurations config = new DBConfigurations();

        try {
            conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);
            while(rs.next()){
                User usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setName(rs.getString("name"));
                usr.setLastname(rs.getString("lastname"));
                usr.setEmail(rs.getString("email"));
                usr.setPhone(rs.getString("phone"));
                users.add(usr);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs != null && stmt != null && conn != null){
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    public int insert(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        DBConfigurations config = new DBConfigurations();

        try {
            conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());

            System.out.println("query: " + SQL_INSERT);
            rows = ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps != null && conn != null){
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return rows;
    }

    public int update(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        DBConfigurations config = new DBConfigurations();

        try {
            conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getId());

            rows = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps != null && conn != null){
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return rows;
    }

    public int delete(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        DBConfigurations config = new DBConfigurations();
        try {
            conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, user.getId());
            rows = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps != null && conn != null){
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return rows;
    }
}
