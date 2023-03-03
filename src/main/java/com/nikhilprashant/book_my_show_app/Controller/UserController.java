package com.nikhilprashant.book_my_show_app.Controller;

import com.nikhilprashant.book_my_show_app.EntryDTOs.UserEntryDto;
import com.nikhilprashant.book_my_show_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody UserEntryDto userEntryDto) {
        try {
            String response = userService.createUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            String response = "Failed to create user";
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
