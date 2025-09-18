package com.example.ss3_bai_1.service;

import com.example.ss3_bai_1.entity.Email;
import com.example.ss3_bai_1.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    private final IEmailRepository emailRepository;

    public EmailService(IEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email getSettings() {
        return emailRepository.getSettings();
    }

    @Override
    public void update(Email settings) {
        emailRepository.update(settings);
    }
}
