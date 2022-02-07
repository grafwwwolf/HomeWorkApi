import ru.home.service.drivers.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connection = DBConnection.getConnection();
            statement = DBConnection.getStatement();
            DBConnection.createTableUsers();
//            DBConnection.insertUser("grafwwwolf", "password", "grafwwwolf");
//            DBConnection.insertUser("robertrath", "password", "robertrath");
//            DBConnection.insertUser("markel", "password", "markel");
            System.out.println(DBConnection.getNickNameByLoginAndPassword("grafwwwolf", "password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

    }

}

