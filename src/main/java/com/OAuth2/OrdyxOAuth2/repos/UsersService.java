/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OAuth2.OrdyxOAuth2.repos;

import com.OAuth2.OrdyxOAuth2.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service
public class UsersService{
    
    @Autowired
    UsersRepository userRepo;
    
    
    public User add(User user){
        userRepo.save(user);
        return user;
    }
    
    public void delete(long userId){
        userRepo.deleteById(userId);
    }
    
    public List<User> getUsers(){
        return (List<User>) userRepo.findAll();    
    }
    
    public User getUserById(long userId) throws Exception{
        Optional<User> optionalUser = userRepo.findById(userId);
        return optionalUser.orElseThrow(() -> new Exception("Couldn't find a User with id: " + userId));
    }
    
}
