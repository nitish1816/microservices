package com.example.UserService.controller;

import com.example.UserService.entity.User;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice;
    //create user
    @PostMapping("/adduser")
    public ResponseEntity<User> adduser(@RequestBody User user){
        User saveduser= userservice.adduser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
    }

    //get single user by id
    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getuser(@PathVariable("id") Integer id){
        User user=userservice.getuser(id);
        System.out.println("hello test");
        return ResponseEntity.ok(user);
    }
    //get all user
    @GetMapping("/getalluser")
    public ResponseEntity<List<User>>  getalluser(){
        List<User> getall=userservice.getalluser();
        return ResponseEntity.ok(getall);
    }

}
