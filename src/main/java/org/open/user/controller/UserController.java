package org.open.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.open.user.entity.User;
import org.open.user.service.UserService;
import org.open.user.vo.UserDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDepartment getUserWithDepartment(@PathVariable("id") long userId) {
        log.info("Inside getUserWithDepartment method");
        return userService.getUserWithDepartment(userId);
    }
}
