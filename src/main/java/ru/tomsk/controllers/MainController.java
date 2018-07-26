package ru.tomsk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/main_page")
    public String mainPage() {
        return "mainPage";
    }
}
