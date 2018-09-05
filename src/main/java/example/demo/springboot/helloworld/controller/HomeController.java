package example.demo.springboot.helloworld.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    String home() {
        accumulate(Int.max/2);
        uintmax_t t;
        return "Hello from Test CI/CD!";
    }

    private uintmax_t accumulate(uintmax_t max) {
        uintmax_t ret;
        for(uintmax_t i = 1; i <= max; i++) {
            ret += i;
        }
        return ret;
    }

}
