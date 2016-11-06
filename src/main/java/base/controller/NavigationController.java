package base.controller;

import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
    @Autowired
    SimInfoService simInfoService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("simInfos", simInfoService.findAll());
        return "home";
    }

    @Deprecated                 ////
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("simInfos", simInfoService.findAll());
        return "allEntries";
    }

    @RequestMapping(value = "/{id}")
    public String update(Model model, @PathVariable Long id) {
        model.addAttribute("editedSimInfo", simInfoService.getById(id)); //поменял, проверить
        return "editEntry";
    }

}
