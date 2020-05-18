package org.acme.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Inject
    KeypassService keypassService;


    @GetMapping
    public String hello() throws FileNotFoundException {
        keypassService.checkKeyPassService();
        return "hello";
    }
}