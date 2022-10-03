package com.k8s.k8sapp.command;

import com.k8s.k8sapp.model.ModelBase;
import com.k8s.k8sapp.model.User;

public class UserCommand extends ModelBase {

    private String name;
    private String lastName;
    private String role;

    public UserCommand() {
    }

    public UserCommand(User user) {
        setId(user.getId());
        setName(user.getName());
        setLastName(user.getLastName());
        setRole(user.getRole());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User toUser(){
        User user = new User();
        user.setId(getId());
        user.setName(getName());
        user.setLastName(getLastName());
        user.setRole(getRole());
        return user;
    }
}
