package org.sujoy.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guchu")
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Hello World from Spring Boot!!!";
    }
    @RequestMapping("/more")
    public String more(){
        return "Playing with Hello World from Spring Boot!!!";
    }

}
