package com.software2ex.apiRest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2ex.apiRest.MODEL.user;




@RestController
@RequestMapping("/api/user")


public class userController {

private List <user> users;

public userController(){

    try {
        ObjectMapper objectMapper =  new ObjectMapper();
        user[] usersArray =  objectMapper.readValue(new ClassPathResource("users.json").getFile(), user[].class);  
        users = new ArrayList<>(Arrays.asList(usersArray));
    } catch (IOException e) {
        e.printStackTrace();
        users = new ArrayList<>();
       
    }

}

@GetMapping
public List<user> getallUsers(){
    return users;
}
@GetMapping("/{id")
public user getUserById(@PathVariable long id){
    return users.stream()
    .filter(user -> user.getId() == id)
    .findFirst()
    .orElse(null);
}

@PostMapping("/{id")
public user  createUser(@RequestBody user user){
    users.add(user);
    return user;
}


@PutMapping("/{id")
public User updateuser(@PathVariable Long id ,@RequestBody user updateUser) {
    user user = getUserById(id);
    if (user != null){
        user.setproducto(updateUser.getproducto());
        user.setcodigoproducto(updateUser.getcodigoproducto());
        return (User) user;
    }
    return null;
}
@DeleteMapping("/{id}")
public void deleteUser (@PathVariable Long id){
    

}
}

