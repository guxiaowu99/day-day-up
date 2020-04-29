package io.study.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
    @RequestMapping("/test")
    public String TestStudy(){
        return "study day day up";
    }
}
