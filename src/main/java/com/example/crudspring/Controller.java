package com.example.crudspring;

import java.util.concurrent.atomic.AtomicLong;

import com.example.crudspring.models.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting getMethodName(@RequestParam(value = "name", defaultValue = "World!") String param) {
        return new Greeting(counter.incrementAndGet(), String.format(template, param));
    }

    @GetMapping("/random")
    public Rand rand(@RequestParam(value = "bound",defaultValue = "100") String bound,
                    @RequestParam(value = "size", defaultValue = "50") String size,
                    @RequestParam(value = "origin", defaultValue = "0") String origin){
        return new Rand(Long.parseLong(size),Integer.parseInt(origin),Integer.parseInt(bound));
    }
}