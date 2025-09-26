package com.example.ss8_ung_dung_muon_sach.service;

import com.example.ss8_ung_dung_muon_sach.entity.Book;
import com.example.ss8_ung_dung_muon_sach.entity.Borrow;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findBYId(Integer id);

    Borrow borrowBook(Integer bookId);

    void returnBook(String borrowCode);
}
