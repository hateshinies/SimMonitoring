package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class NavigationController {

    @Autowired
    SimInfoService simInfoService;

    @RequestMapping("/")
    public String index(Model model) {
        List<SimInfo> simInfos = simInfoService.findByFunctioningTrue();
        model.addAttribute("simInfos", simInfos);
        return "home";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable Long id) {
        SimInfo current = simInfoService.findSimInfoById(id);
        List<SimInfo> simInfos = simInfoService.findByFunctioningTrue();
        model.addAttribute("editedSimInfo", current);
        model.addAttribute("simInfos", simInfos);
        return "editEntry";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable Long id) {
        simInfoService.delete(id);
        model.addAttribute("simInfos", simInfoService.findByFunctioningTrue());
        return "redirect:/";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("simInfos", simInfoService.findAll());
        return "allEntries";
    }

}
