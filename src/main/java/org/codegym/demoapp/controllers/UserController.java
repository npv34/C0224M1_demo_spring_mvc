package org.codegym.demoapp.controllers;

import org.codegym.demoapp.entities.User;
import org.codegym.demoapp.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {
    public List<User> listUser;
    private final ServletContext servletContext;

    public UserController(ServletContext servletContext) {
        listUser = new ArrayList<User>();
        listUser.add(new User(1, "Nam"));
        listUser.add(new User(2, "Huy"));
        listUser.add(new User(5, "Tam"));
        this.servletContext = servletContext;
    }

    @GetMapping("")
    public String listUsers(Model model) {
        // xu ly request method GET voi url /users
        model.addAttribute("listUser", listUser);
        return "users/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable int id, Model model) {
        // xu ly request method GET voi url /users/{id}/delete
        listUser.removeIf(user -> user.getId() == id);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        // xu ly request method GET voi url /users/add
        return "users/add";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("userRequest") UserRequest userRequest, BindingResult result) {
        // xu ly upload file
        MultipartFile avatar = userRequest.getAvatar();
        if (avatar != null && !avatar.isEmpty()) {
            String fileName = avatar.getOriginalFilename();
            // Lấy đường dẫn thư mục gốc của dự án
            String uploadPath = servletContext.getRealPath("/WEB-INF/static/uploads/");
            System.out.println(uploadPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create the directory if it doesn't exist
            }

            assert fileName != null;
            // Lưu file vào thư mục "resources/uploads" trong dự án
            File destinationFile = new File(uploadDir, fileName);
            try {
                avatar.transferTo(destinationFile);
                int id = listUser.get(listUser.size() - 1).getId() + 1;
                User user = new User(id, userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(), fileName);
                listUser.add(user);
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        // xu ly request method POST voi url /users/add
        System.out.println(userRequest.getName());
        return "redirect:/users";
    }
}
