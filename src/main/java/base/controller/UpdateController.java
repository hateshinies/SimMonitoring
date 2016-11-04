package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UpdateController {

    @Autowired
    private SimInfoService simInfoService;

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable Long id, @RequestHeader("host")
            String hostname, HttpServletRequest request, @RequestParam ("Operator") String operator,
                         @RequestParam ("Employee") String employee, @RequestParam ("Location") String location,
                         @RequestParam ("Owner") String owner){
        SimInfo simInfo = simInfoService.getById(id);
        simInfo.setLastLocation(simInfo.getCurLocation());
        simInfo.setCurLocation(location);
        simInfo.setEmployeeSurname(employee);
        simInfo.setOwnerSurname(owner);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setHostName(hostname);
        simInfo.setHostName(request.getRemoteUser());
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfo.setFunctioning(true);   //
        simInfo.setOperator(operator);
        simInfoService.save(simInfo);
        return "redirect:/";
    }
}
