package base.controller;

import base.service.SimInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
    SimInfoService simInfoService;

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute(simInfoService.findAll());
        return "allEntries";
    }

}
