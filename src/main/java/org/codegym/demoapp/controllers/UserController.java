package org.codegym.demoapp.controllers;

import org.codegym.demoapp.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    public List<User> listUser;

    public UserController() {
        listUser = new ArrayList<User>();
        listUser.add(new User(1, "Nam"));
        listUser.add(new User(2, "Huy"));
        listUser.add(new User(5, "Tam"));
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
    public String saveUser(@RequestParam("name") String name) {
        // xu ly request method POST voi url /users/add
        User lastUser = listUser.get(listUser.size() - 1);
        listUser.add(new User(lastUser.getId() + 1 , name));
        return "redirect:/users";
    }
}
