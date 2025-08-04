package com.example.calendar.dto;

import com.example.calendar.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String contents;
    private String name;
    private Long scheduleId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContent();
        this.name = comment.getName();
        this.scheduleId = comment.getSchedule().getId();
    }
}
