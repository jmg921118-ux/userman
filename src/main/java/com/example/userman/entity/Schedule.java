package com.example.userman.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    private String contents;
    private String username;


    public Schedule(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;

    }

    public void update(String title) {
        this.title = title;


    }
}
