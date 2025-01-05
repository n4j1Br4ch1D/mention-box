package com.anmoon.mentionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "pages/index";
    }

    @GetMapping("/about-us")
    public String about(Model model) {
//        model.addAttribute("name", "name!");
        return "pages/about";
    }

    @GetMapping("/contact-us")
    public String contact(Model model) {
//        model.addAttribute("name", "name!");
        return "pages/contact";
    }

    @GetMapping("/privacy-policy")
    public String privacyPolicy(Model model) {
//        model.addAttribute("name", "name!");
        return "pages/privacyPolicy";
    }

    @GetMapping("/terms-and-conditions")
    public String termsAndConditions(Model model) {
//        model.addAttribute("name", "name!");
        return "pages/termsAndConditions";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
//        model.addAttribute("name", "name!");
        return "pages/dashboard";
    }

}
