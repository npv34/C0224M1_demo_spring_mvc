package org.codegym.demoapp.controllers;

import org.codegym.demoapp.models.User;
import org.codegym.demoapp.request.UserRequest;
import org.codegym.demoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("")
    public String listUsers(Model model) throws SQLException {
        List<User> users = userService.getAllUser();
        // xu ly request method GET voi url /users
        System.out.println(users.size());
        model.addAttribute("users", users);
        return "users/list";
    }


}
