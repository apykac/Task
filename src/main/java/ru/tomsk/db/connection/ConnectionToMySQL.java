package ru.tomsk.db.connection;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionToMySQL implements ConnectionManager {
    private static final Logger logger = Logger.getLogger(ConnectionToMySQL.class);
    private final String url = "jdbc:mysql://localhost:3306/task?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
    private final String user = "root";
    private final String pwd = "1234";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    private ConnectionToMySQL() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, user, pwd);
        //flyway.baseline();
        flyway.migrate();
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}
