package com.example.ss7_bai_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname ")
    private String lastname ;

    @Column(name = "phone_number ")
    private Integer phoneNumber ;

    @Column(name = "age ")
    private Integer age ;

    @Column(name = "email ")
    private String email ;
}
