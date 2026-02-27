package com.project.journalApp.controller;


import com.project.journalApp.api.response.WeatherResponse;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import com.project.journalApp.service.UserService;
import com.project.journalApp.service.WeatherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name="User API's")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WeatherService  weatherService;

//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAll();
//    }

    @PostMapping
    public void createUser(@RequestBody User user ){
        userService.saveNewUser(user);

    }


    @PutMapping
    public ResponseEntity<?>updateUser(@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();

        User userInDB =userService.findByusername(username);
        userInDB.setUsername(user.getUsername());
        userInDB.setPassword(user.getPassword());
        userService.saveNewUser(userInDB);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping
    public ResponseEntity<?>deleteUser(@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        userRepository.deleteByUsername(authentication.getName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse=weatherService.getWeather("Mumbai");
        String Greeting="";
        if (weatherResponse!=null)
        {
            Greeting=" Weather feels like "+weatherResponse.getCurrent().getFeelslike();

        }

        return new ResponseEntity<>("Hi "+ authentication.getName()+Greeting, HttpStatus.OK);
    }
}
