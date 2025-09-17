package com.example.ss1_bai_tap_2.service;

import com.example.ss1_bai_tap_2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    public IDictionaryRepository repository;


    @Override
    public String findByWord(String word) {
        return repository.findByWord(word);
    }
}
