package com.pedro.spring_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String features = "sum(x+y), sub(x-y), sqrt(x), div(x/y), mult(x*y)";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public Greeting greeting(
            String name) {
        return new Greeting(counter.incrementAndGet(), features);
    }

}
