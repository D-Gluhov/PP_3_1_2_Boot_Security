package ru.kata.spring.boot_security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin/users")
@AllArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "allUsers";
    }

    @GetMapping("/info")
    public String userInfo(@RequestParam(name = "id", required = false) Integer id, Model model) {
        userService.validateUserId(id, model);
        return "userInfo";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
