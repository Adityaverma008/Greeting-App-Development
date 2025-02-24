package com.example.Greeting_App.Controller;

import com.example.Greeting_App.Entity.Greeting;
import com.example.Greeting_App.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//uc4 codefiles

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

//    uc5 code files

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

//    uc6 code

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

//    uc7 codefiles

    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.editGreeting(id, newMessage);
    }

}
