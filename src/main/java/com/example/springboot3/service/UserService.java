package com.example.springboot3.service;

import com.example.springboot3.dto.request.UserRequestDto;
import com.example.springboot3.dto.response.PageResponse;
import com.example.springboot3.dto.response.UserDetailResponse;
import com.example.springboot3.enums.UserStatus;

import java.util.List;

public interface UserService {
    long saveUser(UserRequestDto request);

    void updateUser(long userId, UserRequestDto request);

    void changeStatus(long userId, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy);

    PageResponse<?> getAllUsersWithSortByMultipleColumns(int pageNo, int pageSize, String... sorts);
}
