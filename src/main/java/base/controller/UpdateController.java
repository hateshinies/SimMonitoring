package base.controller;

import base.domain.AnimalLoss;
import base.service.AnimalLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UpdateController {

    @Autowired
    private AnimalLossService animalLossService;

    @RequestMapping(value = "/update")
    public String update(@RequestHeader("ed_id") long id,
                         HttpServletRequest request,
                         @RequestParam("ed_age") String age,
                         @RequestParam("ed_email") String email,
                         @RequestParam("ed_city") String city,
                         @RequestParam("ed_phone") String phone,
                         @RequestParam("ed_reward") String reward,
                         @RequestParam("ed_description") String description
    ) {
        AnimalLoss animalLoss = animalLossService.getById(id);
        if (animalLoss == null) return "redirect:/error";
        animalLoss.setAge(age);
        animalLossService.save(animalLoss);
        return "redirect:/";
    }
}
