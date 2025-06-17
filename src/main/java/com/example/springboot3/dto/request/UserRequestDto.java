package com.example.springboot3.dto.request;

import java.io.Serializable;

public class UserRequestDto implements Serializable {
    // Serializable dùng để chuyển đổi từ JSON sang byte nhị phân và ngược lại
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public UserRequestDto(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
}
