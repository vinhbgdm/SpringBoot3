package com.example.springboot3.controller;

import com.example.springboot3.dto.request.UserRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/", headers = "apikey=v1.0")
//    @RequestMapping(method = RequestMethod.POST, path = "/", headers = "apikey=v1.0")
    public String addUser(@RequestBody UserRequestDto userDto){
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userDto){
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable Long userId, @RequestParam(required = false) boolean status){
        return "User updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUser(@PathVariable Long userId){
        return new UserRequestDto("", "", "", "");
    }

    @GetMapping("/list")
    public List<UserRequestDto> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        return List.of(new UserRequestDto("", "", "", ""),
                new UserRequestDto("", "", "", ""));
    }
}
