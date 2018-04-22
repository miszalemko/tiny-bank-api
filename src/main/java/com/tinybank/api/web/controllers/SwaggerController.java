package com.tinybank.api.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SwaggerController {

    @GetMapping("documentation")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
