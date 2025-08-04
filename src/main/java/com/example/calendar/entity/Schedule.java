package com.example.calendar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedules")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    @Column(name = "created_at")
    private LocalDateTime creatAt;
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    // 하나의 schedule에 여러 개의 comment
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.creatAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.updateAt = LocalDateTime.now();
    }
}
