package base.controller;

import base.domain.AnimalLoss;
import base.service.AnimalLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class AddEntryController {

    @Autowired
    private AnimalLossService animalLossService;

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("ad_age") String age,
                      @RequestParam("ad_email") String email,
                      @RequestParam("ad_city") String city,
                      @RequestParam("ad_phone") String phone,
                      @RequestParam("ad_reward") String reward,
                      @RequestParam("ad_description") String description
                      ) {
        AnimalLoss animalLoss = new AnimalLoss();
        animalLoss.setAge(age);
        animalLoss.setEmail(email);
        animalLoss.setCity(city);
        animalLoss.setPhoneNumber(phone);
        animalLoss.setReward(reward);
        animalLoss.setDescription(description);
        animalLossService.save(animalLoss);
        sendEmail(email);
        return "redirect:/";
    }

    void sendEmail(String address) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sbuigji@yandex.ru");
        msg.setFrom("searchingpets@yandex.ru");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);
    }

   /* private String validateNumber(String phoneNumber) {
        switch (phoneNumber.length()) {
            case 12:
                if (phoneNumber.startsWith("+")) return phoneNumber;
            case 11:
                return "+" + phoneNumber;
            case 10:
                return "+7" + phoneNumber;
            default:
                return "error";
        }
    }*/
}
