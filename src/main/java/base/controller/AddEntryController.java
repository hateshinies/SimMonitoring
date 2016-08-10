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
    public String add(@RequestParam ("PhoneNumber") String phoneNumber, @RequestParam ("Operator") String operator,
                      @RequestParam ("Employee") String employee, @RequestParam ("Location") String location,
                      @RequestParam ("Owner") String owner){
        //validate phoneNumber
        if (phoneNumber.length() != 11 || phoneNumber.length() != 12 && phoneNumber.startsWith("+")) return "allEntries";//todo
        long id = Long.parseLong(phoneNumber.substring(phoneNumber.length() - 5));  //взять последние 4 цифры
        if (simInfoService.exists(id)) id++;
        SimInfo simInfo = new SimInfo();
        simInfo.setId(id);
        simInfo.setFunctioning(true);
        simInfo.setCurLocation(location);
        simInfo.setEmployeeSurname(employee);
        simInfo.setOwnerSurname(owner);
        simInfo.setPhoneNumber(phoneNumber);
        simInfo.setOperator(operator);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfoService.save(simInfo);
        return "redirect:/all";
    }
}
