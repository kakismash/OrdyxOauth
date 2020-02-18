/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OAuth2.OrdyxOAuth2.controller;

import com.OAuth2.OrdyxOAuth2.entity.User;
import com.OAuth2.OrdyxOAuth2.repos.UsersService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfia
 */
@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    private UsersService userServR;

    //For getting all the transactions
    @RequestMapping(value = "/users", method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        
        System.out.println(userServR.getUsers());
        return new ResponseEntity<List<User>>((List<User>) userServR.getUsers(), HttpStatus.OK);

    }

    //For getting whether the transaction with a given id is rejected or accepted
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String screenTransaction(@PathVariable long userId) throws Exception  {
        User user = userServR.getUserById(userId);
        
        
        return user.toString();
    }

    //For adding a transaction
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User theUser){

        return userServR.add(theUser);
    }

    //For updating a transaction
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User theUser) throws Exception{
        User user = userServR.getUserById(theUser.getUserId());
        if (user == null) {
            throw new RuntimeException("User to update doesn't exist");
        }
        return (userServR.add(theUser));
    }

    //For deleting a transaction
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public String deleteTransaction(@PathVariable long userId) throws Exception{
        User tempUser = userServR.getUserById(userId);
        if(tempUser == null){
            throw new RuntimeException("User Id not found");
        }
        userServR.delete(userId);
        return "deleted user id " + userId;

    }
}
