package com.neoteric.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class HiController {


//    private List<>


    @GetMapping("/protected")
    public String sayHi(){
        return "HI";
    }


    @GetMapping("/nonProtected")
    public String nonProtected(){
        return "nonProtected";
    }

}
