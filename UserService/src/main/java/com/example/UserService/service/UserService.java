package com.example.UserService.service;

import com.example.UserService.entity.User;

import java.util.List;

public interface UserService {

    //create an user
    User adduser(User user);

    //get all user
    List<User> getalluser();

    //get single user by it's id
    User getuser(Integer id);

    //Delete an user by it's id
    User deleteuser(Integer id);

    //delete all user
    void deletealluser();

    /*//update an user
    User updateuser(Integer id);*/

}
