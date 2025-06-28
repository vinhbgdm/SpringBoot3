package com.example.springboot3.service;

import com.example.springboot3.dto.request.UserRequestDto;
import com.example.springboot3.dto.response.PageResponse;
import com.example.springboot3.dto.response.UserDetailResponse;
import com.example.springboot3.enums.UserStatus;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    long saveUser(UserRequestDto request) throws MessagingException, UnsupportedEncodingException;

    void updateUser(long userId, UserRequestDto request);

    void changeStatus(long userId, UserStatus status);

    String confirmUser(int userId, String verifyCode);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy);

    PageResponse<?> getAllUsersWithSortByMultipleColumns(int pageNo, int pageSize, String... sorts);

    PageResponse<?> getAllUsersAndSearchWithPagingAndSorting(int pageNo, int pageSize, String search, String sortBy);

    PageResponse<?> advanceSearchWithCriteria(int pageNo, int pageSize, String search, String address, String... sorts);

    PageResponse<?> advanceSearchWithSpecifications(Pageable pageable, String[] user, String[] address);
}
