package com.example.Greeting_App.Entity;

import jakarta.persistence.*;

@Entity
public class Greeting {
//    UC4 code files
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }

    public Long getId() { return id; }
    public String getMessage() { return message; }

//    UC7code
    public void setMessage(String newMessage) {
    }
}
