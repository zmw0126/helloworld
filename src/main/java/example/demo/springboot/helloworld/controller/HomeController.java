package example.demo.springboot.helloworld.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    String home() {
        
        return "Hello from Test CI/CD!";
    }

    @RequestMapping("/highcpu")
    String highcpu() {
        highCPU();
        return "High CPU Test Case!";
    }

    private void highCPU() {
        for (int i = 0; i < 99999999; i++) {
            accumulate(Integer.MAX_VALUE/2);
        }
    }
    private long accumulate(long max) {
        long ret = 0;
        for(long i = 1; i <= max; i++) {
            ret += i;
        }
        return ret;
    }

}
