package example.demo.springboot.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    String home() {
        //from Test CI/CD
        String msg = "Hello World!";
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/health")
    String health() {
        return "{\"status\":\"UP\"}";
    }

    @RequestMapping("/highcpu")
    String highcpu() {
        highCPU();
        return "High CPU Test Case!";
    }

    @RequestMapping("/oom")
    String oom() {
        try {
            for (int i = 0; i < 10000000; i++) {
                byte[] mem = new byte[1024];
                mem[0] = 0;
            }
        } catch(Throwable e) {
            System.out.println("OOM Error " + e);
            //throw e;
        }
        return "OOM Test Case!";
    }

    private void highCPU() {
        for (int i = 0; i < 100; i++) {
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
