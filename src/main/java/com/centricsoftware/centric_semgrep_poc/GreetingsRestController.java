package com.centricsoftware.centric_semgrep_poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest/greetings")
public class GreetingsRestController {

    @GetMapping
    public String greet(@RequestParam(value="name", required = false, defaultValue = "John Doe") String name) {
	return "{\"greetings\": \"Hello! " + name + "\"}";
    }

}
