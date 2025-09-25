package com.example.ss7_bai_1.repository;

import com.example.ss7_bai_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
