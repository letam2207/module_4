package com.example.ss1_bai_tap_1.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    private static final int RATE = 24000;

    @Override
    public Integer convertUsdToVnd(Integer usd) {
        if (usd == null) {
            return 0;
        }
        return usd * RATE;
    }

}
