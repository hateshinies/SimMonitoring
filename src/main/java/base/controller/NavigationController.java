package base.controller;

import base.service.AnimalLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
    @Autowired
    AnimalLossService animalLossService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("animalLosses", animalLossService.findAll());
        return "home";
    }

    @Deprecated                 ////
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("animalLosses", animalLossService.findAll());
        return "allEntries";
    }

    @RequestMapping(value = "/{id}")
    public String update(Model model, @PathVariable Long id) {
        model.addAttribute("editAnimalLoss", animalLossService.getById(id));
        model.addAttribute("animalLosses", animalLossService.findAll());
        return "editEntry";
    }

}
