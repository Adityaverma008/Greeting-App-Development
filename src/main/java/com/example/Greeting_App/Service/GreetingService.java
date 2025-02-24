package com.example.Greeting_App.Service;

import com.example.Greeting_App.Entity.Greeting;
import com.example.Greeting_App.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
//    UC2 code files
    public String getGreetingMessage() {
        return "Hello World";
    }

//    UC3 code files


    public String getGreetingMessage(String firstName, String lastName) {

        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        }
        return "Hello World";
    }

//        uc4Codefiles
    @Autowired
    private GreetingRepository greetingRepository;

    public <Greeting> Greeting saveGreeting(String message) {
        return greetingRepository.save(new greeting(message));
    }

//    uc5 codefiles
public Greeting getGreetingById(Long id) {
    return greetingRepository.findById(id).orElse(null);
}


//UC6 codefiles
public List<Greeting> getAllGreetings() {
    return greetingRepository.findAll();
}

//UC7 codefiles
public Greeting editGreeting(Long id, String newMessage) {
    return greetingRepository.findById(id).map(greeting -> {
        greeting.setMessage(newMessage);
        return greetingRepository.save(greeting);
    }).orElse(null);
}
//uc8 codefiles
public String deleteGreeting(Long id) {
    if (greetingRepository.existsById(id)) {
        greetingRepository.deleteById(id);
        return "Deleted successfully";
    }
    return "Greeting not found";
}

}
