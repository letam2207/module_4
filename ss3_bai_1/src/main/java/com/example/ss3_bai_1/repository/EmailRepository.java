package com.example.ss3_bai_1.repository;

import com.example.ss3_bai_1.entity.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{
    private Email settings = new Email("English", 25, true, "King, Asgard");

    @Override
    public Email getSettings() {
        return settings;
    }

    @Override
    public void update(Email settings) {
        this.settings = settings;
    }
}
