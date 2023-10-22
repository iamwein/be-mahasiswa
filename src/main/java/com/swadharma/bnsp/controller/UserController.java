package com.swadharma.bnsp.controller;

import com.swadharma.bnsp.payload.UserDto;
import com.swadharma.bnsp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/bnspsert/v1/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return new ResponseEntity<>(userService.createNewUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAllUser();
    }
}
