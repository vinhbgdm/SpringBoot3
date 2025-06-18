package com.example.springboot3.service;

import com.example.springboot3.dto.request.UserRequestDto;

public interface UserService {
    int addUser(UserRequestDto user);
}
