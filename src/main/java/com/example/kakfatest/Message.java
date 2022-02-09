package com.example.kakfatest;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private String author;
    private String content;
    private String timestamp;
}