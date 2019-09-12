package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MyController {

    @GetMapping("/")
    String index(){
        return "index";
    }

    @GetMapping("/secured")
    String secure(){
        return "secured";
    }
}
