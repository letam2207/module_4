package com.example.ss8_ung_dung_muon_sach.repository;

import com.example.ss8_ung_dung_muon_sach.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowRepository extends JpaRepository<Borrow,Integer> {
    Optional<Borrow> findByBorrowCode(String borrowCode);
}
