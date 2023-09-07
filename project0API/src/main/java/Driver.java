import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
