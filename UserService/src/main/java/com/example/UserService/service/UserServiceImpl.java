package com.example.UserService.service;

import com.example.UserService.entity.User;
import com.example.UserService.exception.ResourceNotFoundException;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userrepo;
    public User adduser(User user){
        return userrepo.save(user);
    }
    public List<User> getalluser(){
        List<User> getall=userrepo.findAll();
        return getall;

    }
    public User getuser(Integer id){
        User user=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Given user id is not present"+id));
        return user;
    }
    public User deleteuser(Integer id){
           User user=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Given user id is not present"+id));
      //  return userrepo.deleteById(id).orElseThrow(()->new ResourceNotFoundException("Given user id not found to delete"+id));
      userrepo.deleteById(id);
      return user;
    }
    public void deletealluser(){
        userrepo.deleteAll();
    }

}
