package com.carnet.carnet.sec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class securityController {
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/index";

    }
    @RequestMapping(value = "/403")
    public String accessDenied() {
        return "403 ";

    }
}
