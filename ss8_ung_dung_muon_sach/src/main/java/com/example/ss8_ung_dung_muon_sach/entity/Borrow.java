package com.example.ss8_ung_dung_muon_sach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "borrows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "borrows_code")
    private String borrowCode;

    @Column(name = "status")
    private BorrowStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public enum BorrowStatus {
        BORROWED, RETURNED
    }
}
