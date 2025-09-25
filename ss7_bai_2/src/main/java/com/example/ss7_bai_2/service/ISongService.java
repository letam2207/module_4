package com.example.ss7_bai_2.service;

import com.example.ss7_bai_2.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void update(Song song);
    Song findById(Integer id);
}
