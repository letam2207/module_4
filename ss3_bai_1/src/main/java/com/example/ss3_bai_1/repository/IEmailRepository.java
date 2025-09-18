package com.example.ss3_bai_1.repository;

import com.example.ss3_bai_1.entity.Email;

import java.util.List;

public interface IEmailRepository {
    Email getSettings();
    void update(Email settings);
}
