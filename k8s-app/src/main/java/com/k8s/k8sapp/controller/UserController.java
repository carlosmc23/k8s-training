/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package com.k8s.k8sapp.controller;

import com.k8s.k8sapp.model.User;
import com.k8s.k8sapp.services.UserService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@Api(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/new")
    public User addNewUser(@RequestParam(value = "Name") String name,
                           @RequestParam(value = "LastName", required = false) String lastName,
                           @RequestParam(value = "Role", required = false) String role) {
        return userService.addNewUser(name, lastName, role);
    }

    @PutMapping(path = "/info/{id}")
    public User updateUserInfo(@PathVariable Long id,
                               @RequestParam(value = "Fist Name") String name,
                               @RequestParam(value = "LastName", required = false) String lastName,
                               @RequestParam(value = "Role",required = false) String role) {
        return userService.updateUserInfo(id, name, lastName, role);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
