package com.example.crudspring;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting getMethodName(@RequestParam(value = "name", defaultValue = "World!") String param) {
        return new Greeting(counter.incrementAndGet(), String.format(template, param));
    }
}