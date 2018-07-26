package ru.tomsk.db.connection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionToMySQL implements ConnectionManager {
    private static final Logger logger = Logger.getLogger("defaultLog");

    private ConnectionToMySQL() {
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/task?" +
                            "serverTimezone=UTC" +
                            "&useUnicode=yes" +
                            "&characterEncoding=UTF-8",
                    "root",
                    "1234");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}
