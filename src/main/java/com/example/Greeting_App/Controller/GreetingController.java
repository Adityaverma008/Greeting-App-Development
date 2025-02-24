package com.example.Greeting_App.Controller;

import com.example.Greeting_App.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
//    UC1 codeefiles
    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello World\"}";
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Greeting received!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Greeting updated!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted!\"}";
    }

    //    uc2 code files
    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public String getGreeting2() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

//    UC3 code files
@GetMapping
public String getGreeting(@RequestParam(required = false) String firstName,
                          @RequestParam(required = false) String lastName) {
    return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
}

}
