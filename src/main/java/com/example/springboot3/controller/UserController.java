package com.example.springboot3.controller;

import com.example.springboot3.dto.request.UserRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/", headers = "apikey=v1.0")
//    @RequestMapping(method = RequestMethod.POST, path = "/", headers = "apikey=v1.0")
    public String addUser(@Valid @RequestBody UserRequestDto userDto){
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @Valid @RequestBody UserRequestDto userDto){
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeUserStatus(@PathVariable Long userId, @Valid @RequestParam(required = false) boolean status){
        return "User updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable Long userId){
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUser(@PathVariable Long userId){
        return new UserRequestDto("Ninh", "Vinh", "ndvinh2001@gmail.com", "0123456789");
    }

    @GetMapping("/list")
    public List<UserRequestDto> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        return List.of(new UserRequestDto("Ninh", "Vinh", "ndvinh2001@gmail.com", "0123456789"),
                new UserRequestDto("Ninh", "Vinh", "ndvinh2001@gmail.com", "0123456789"));
    }
}
