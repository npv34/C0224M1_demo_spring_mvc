package org.codegym.demoapp.services;

import org.codegym.demoapp.models.User;
import org.codegym.demoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() throws SQLException {
        ResultSet resultSet = userRepository.getAllUsers();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getInt("id"), resultSet.getString("name"));
            list.add(user);
        }

        return list;
    }
}
