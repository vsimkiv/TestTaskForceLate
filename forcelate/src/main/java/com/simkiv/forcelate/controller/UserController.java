package com.simkiv.forcelate.controller;

import com.simkiv.forcelate.dto.UserDto;
import com.simkiv.forcelate.service.UserService;
import com.simkiv.forcelate.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getOne(@PathVariable("userId") long id) {
        return ResponseEntity.ok().body(userService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.save(userDto);
        return ResponseEntity.ok().body(createdUser);
    }
}
