package com.example.ss7_bai_2.repository;

import com.example.ss7_bai_2.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
