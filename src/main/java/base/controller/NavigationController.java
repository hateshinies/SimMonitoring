package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NavigationController {
    @Autowired
    SimInfoService simInfoService;

    @RequestMapping("/")
    public String index(Model model) {
        List<SimInfo> simInfos = simInfoService.findAll();
        model.addAttribute("simInfos", simInfos);
        return "home";
    }

    @RequestMapping(value = "/{id}")
    public String update(Model model, @PathVariable Long id) {
        SimInfo current = simInfoService.getById(id);
        List<SimInfo> simInfos = simInfoService.findAll();
        model.addAttribute("editedSimInfo", current);
//        model.addAttribute("simInfos", simInfos);
        return "editEntry";
    }

    @Deprecated
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("simInfos", simInfoService.findAll());
        return "allEntries";
    }

}
