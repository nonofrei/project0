package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public User login(String username, String password){
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE user_username = ? AND user_password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name")
                );
            }
        } catch(SQLException e){
            System.out.println("LOGIN FAILED");
            e.printStackTrace();
        }
        return null;
    }

}
