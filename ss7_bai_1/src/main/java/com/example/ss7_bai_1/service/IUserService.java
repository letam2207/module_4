package com.example.ss7_bai_1.service;

import com.example.ss7_bai_1.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
