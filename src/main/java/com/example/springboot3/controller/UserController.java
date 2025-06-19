package com.example.springboot3.controller;

import com.example.springboot3.configuration.Translator;
import com.example.springboot3.dto.request.UserRequestDto;
import com.example.springboot3.dto.response.ResponseFailure;
import com.example.springboot3.dto.response.ResponseSuccess;
import com.example.springboot3.exception.ResourceNotFoundException;
import com.example.springboot3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
@Tag(name = "User Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(method = "POST", summary = "Add new user", description = "Send a request via this API to create new user")
    @PostMapping("/")
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDto user) {
        log.info("Request add user {} {}", user.getFirstName(), user.getLastName());
        try {
            userService.addUser(user);
            return new ResponseSuccess(HttpStatus.CREATED, Translator.toLocale("user.add.success"), 1);
        } catch (ResourceNotFoundException e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Update user", description = "Send a request via this API to update user")
    @PutMapping("/{userId}")
    public ResponseSuccess updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDto user) {
        log.info("Request update userId={}", userId);
        try {
            return new ResponseSuccess(HttpStatus.ACCEPTED, Translator.toLocale("user.upd.success"));
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Change status of user", description = "Send a request via this API to change status of user")
    @PatchMapping("/{userId}")
    public ResponseSuccess updateStatus(@Min(1) @PathVariable int userId,
                                        @RequestParam boolean status) {
        log.info("Request change status, userId={}", userId);
        try {
            return new ResponseSuccess(HttpStatus.NO_CONTENT, Translator.toLocale("user.change.success"));
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Delete user permanently", description = "Send a request via this API to delete user permanently")
    @DeleteMapping("/{userId}")
    public ResponseSuccess deleteUser(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int userId) {
        log.info("Request delete userId={}", userId);
        try {
            return new ResponseSuccess(HttpStatus.NO_CONTENT, Translator.toLocale("user.del.success"));
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Get user detail", description = "Send a request via this API to get user information")
    @GetMapping("/{userId}")
    public ResponseSuccess getUser(@PathVariable @Min(1) int userId) {
        log.info("Request get user detail, userId={}", userId);
        try {
            return new ResponseSuccess(HttpStatus.OK, "user", new UserRequestDto("Vinh", "Vinh", "admin@vinhbgdm.vn", "0123456789"));
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Get list of users per pageNo", description = "Send a request via this API to get user list by pageNo and pageSize")
    @GetMapping("/list")
    public ResponseSuccess getAllUser(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                      @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize) {
        log.info("Request get all of users");
        return new ResponseSuccess(HttpStatus.OK, "user", List.of(new UserRequestDto("Vinh", "Java", "admin@vinhbgdm.vn", "0123456789"),
                new UserRequestDto("Ronaldo", "Messi", "leomessi@email.com", "0123456456")));
    }
}
