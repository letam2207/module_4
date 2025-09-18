package com.example.ss3_bai_1.service;

import com.example.ss3_bai_1.entity.Email;

import java.util.List;

public interface IEmailService {
    Email getSettings();
    void update(Email settings);
}
