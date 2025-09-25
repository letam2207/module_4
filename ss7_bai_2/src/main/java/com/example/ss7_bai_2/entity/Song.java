package com.example.ss7_bai_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "songs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "music_genre")
    private String musicGenre;
}
