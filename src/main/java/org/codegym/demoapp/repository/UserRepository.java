package org.codegym.demoapp.repository;

import org.codegym.demoapp.config.JdbcConfig;
import org.codegym.demoapp.models.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private DataSource dataSource;
    private Connection connection;

    public UserRepository() throws SQLException {
        this.dataSource = new JdbcConfig().dataSource();
        this.connection = this.dataSource.getConnection();
    }

    public ResultSet getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        return statement.executeQuery();
    }
}
