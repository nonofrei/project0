package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public User updateUserNameByUserId(int user_id, String user_first_name, String user_last_name){
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE users SET user_first_name = ?, user_last_name = ? WHERE user_id  = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_first_name);
            ps.setString(2, user_last_name);
            ps.setInt(3,user_id);
            ps.executeUpdate();
            return new User(user_id, user_first_name, user_last_name);
        }catch (SQLException e){
            System.out.println("ERROR UPDATING USER");
            e.printStackTrace();
        }
        return null;
    }
}
