package org.codegym.demoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    // xu ly request method GET voi url /home
    @GetMapping("")
    public String home(Model model) {
        // truyen du lieu vao model gui sang view
        model.addAttribute("message", "Xin chao");
        return "home";
    }
}
