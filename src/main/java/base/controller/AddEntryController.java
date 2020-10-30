package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class AddEntryController {

    @Autowired
    private SimInfoService simInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("ad_phoneNumber") String phoneNumber,
                      @RequestParam("ad_operator") String operator,
                      @RequestParam("ad_employee") String employee,
                      @RequestParam("ad_location") String location,
                      @RequestParam(value = "ad_CSD", required = false) boolean CSD //Не передается состояние чекбокса:(
    ) {
        phoneNumber = validateNumber(phoneNumber);
        if (phoneNumber.equals("error")) return "home";
        long id = Long.parseLong(phoneNumber.substring(phoneNumber.length() - 4));  //взять последние 4 цифры
        if (simInfoService.exists(id)) id++;
        SimInfo simInfo = new SimInfo();
        simInfo.setId(id);
        simInfo.setPhoneNumber(phoneNumber);
        simInfo.setOperator(operator);
        simInfo.setEmployee(employee);
        simInfo.setCurLocation(location);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setFunctioning(true);
        simInfo.setCSD(CSD);
        simInfoService.save(simInfo);
        return "redirect:/";
    }

    private String validateNumber(String phoneNumber) {
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
    }
}
