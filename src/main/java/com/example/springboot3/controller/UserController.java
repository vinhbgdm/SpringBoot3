package com.example.springboot3.controller;

import com.example.springboot3.dto.request.UserRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDto user) {
        System.out.println("Request add user " + user.getFirstName());
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDto user) {
        System.out.println("Request update userId=" + userId);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String updateStatus(@Min(1) @PathVariable int userId,
                               @RequestParam boolean status) {
        System.out.println("Request change status, userId=" + userId);
        return "User Status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int userId) {
        System.out.println("Request delete userId =" + userId);
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUser(@PathVariable @Min(1) int userId) {
        System.out.println("Request get user detail, userId=" + userId);
        return new UserRequestDto("Tay", "Java", "admin@tayjava.vn", "0123456789");
    }

    @GetMapping("/list")
    public List<UserRequestDto> getAllUser(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                           @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize) {
        System.out.println("Request get all of users");
        return List.of(new UserRequestDto("Tay", "Java", "admin@tayjava.vn", "0123456789"),
                new UserRequestDto("Leo", "Messi", "leomessi@email.com", "0123456456"));
    }
}
