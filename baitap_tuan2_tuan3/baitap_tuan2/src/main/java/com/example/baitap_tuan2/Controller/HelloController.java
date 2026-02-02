package com.example.baitap_tuan2.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")

public class HelloController {
   @GetMapping("/home")
    public String getHome() {
        return "index";
    }
}
