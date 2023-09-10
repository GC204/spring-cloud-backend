package com.learning.microservice.controller;

import com.learning.microservice.enums.Role;
import com.learning.microservice.model.User;
import com.learning.microservice.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping("/service/registration")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        if(userService.getUserByName(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/service/login")
    public ResponseEntity<?> getUser(Principal principal){
        if(principal == null || principal.getName()==null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(userService.getUserByName(principal.getName()));
    }

    @PostMapping("/service/names")
    public ResponseEntity<?> findNameOfUsers(@RequestBody List<Long> ids){
        return ResponseEntity.ok(userService.getUserListByIds(ids));
    }

    @GetMapping("/service/test")
    public ResponseEntity<?> testApi(){
        return ResponseEntity.ok("It's working");
    }
}
