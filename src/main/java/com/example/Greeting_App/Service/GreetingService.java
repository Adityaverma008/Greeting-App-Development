package com.example.Greeting_App.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
//    UC2 code files
    public String getGreetingMessage() {
        return "Hello World";
    }

//    UC3 code files

    if (firstName != null && lastName != null) {
        return "Hello " + firstName + " " + lastName;
    } else if (firstName != null) {
        return "Hello " + firstName;
    } else if (lastName != null) {
        return "Hello " + lastName;
    }
    return "Hello World";
}
