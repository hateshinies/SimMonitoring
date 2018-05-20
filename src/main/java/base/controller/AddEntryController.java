package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class AddEntryController {


    @Autowired
    private SimInfoService simInfoService;

    @RequestMapping(value = "/add"/*, method = RequestMethod.POST*/)
    public String add(HttpServletRequest request,
                      @RequestParam("phoneNumber") String phoneNumber,
                      @RequestParam("operator") String operator,
                      @RequestParam("location") String location,
                      @RequestParam("owner") String owner,
                      @RequestParam(value = "CSD", required = false) boolean CSD) {
        //validate phoneNumber
        phoneNumber = validateNumber(phoneNumber);
        if (phoneNumber.equals("error")) return "home";
        long id = Long.parseLong(phoneNumber.substring(phoneNumber.length() - 4));  //взять последние 4 цифры
        if (simInfoService.exists(id)) id++;
        SimInfo simInfo = new SimInfo();
        simInfo.setId(id);
        simInfo.setPhoneNumber(phoneNumber);
        simInfo.setFunctioning(true);
        simInfo.setCSD(CSD);
        //simInfo.setEmployeeSurname(request.getUserPrincipal().getName());
        simInfo.setOwnerSurname(owner);
        simInfo.setOperator(operator);
        simInfo.setCurLocation(location);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfoService.save(simInfo);
        return "redirect:/";
    }

    private String validateNumber(String phoneNumber) {
        switch (phoneNumber.length()) {
            case 12:
                if (phoneNumber.startsWith("+"))
                    return phoneNumber;
            case 11:
                if (phoneNumber.startsWith("7"))
                    return "+" + phoneNumber;
                if (phoneNumber.startsWith("8"))
                    return "+7" + phoneNumber.substring(1);
            case 10:
                return "+7" + phoneNumber;
            default:
                return "error";
        }
    }
}
