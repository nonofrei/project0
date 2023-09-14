package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    public User insertUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO users (user_first_name, user_last_name) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUser_first_name());
            ps.setString(2, user.getUser_last_name());
            ps.executeUpdate();
            return user;
        } catch (SQLException e) {
            System.out.println("ERROR INSERT USER");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("GET ALL USERS FAILED");
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int user_id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        user_id,
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name")
                );
            }
        } catch (SQLException e) {
            System.out.println("GET USERS BY ID FAILED");
            e.printStackTrace();
        }
        return null;
    }
}
