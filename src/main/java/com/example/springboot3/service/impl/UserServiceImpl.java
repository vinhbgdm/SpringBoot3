package com.example.springboot3.service.impl;

import com.example.springboot3.dto.request.UserRequestDto;
import com.example.springboot3.exception.ResourceNotFoundException;
import com.example.springboot3.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(UserRequestDto user) {
        System.out.println("Save user to DB");
        if(!user.getFirstName().equals("Vinh")){
            throw new ResourceNotFoundException("Vinh khong ton tai");
        }
        return 0;
    }
}
