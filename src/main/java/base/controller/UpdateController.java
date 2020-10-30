package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UpdateController {

    @Autowired
    private SimInfoService simInfoService;

    @RequestMapping(value = "/update")
    public String update(@RequestHeader("host") String hostname,
                         HttpServletRequest request,
                         @RequestParam("ed_id") long id,
                         @RequestParam("ed_operator") String operator,
                         @RequestParam("ed_employee") String employee,
                         @RequestParam("ed_location") String location,
                         @RequestParam(value = "ed_isFunctioning", required = false) boolean isFunctioning,
                         @RequestParam(value = "ed_CSD", required = false) boolean CSD
                         ) {
        SimInfo simInfo = simInfoService.getById(id);
        if (simInfo == null) return "redirect:/error";
        simInfo.setLastLocation(simInfo.getCurLocation());
        simInfo.setCurLocation(location);
        //simInfo.setEmployeeSurname(request.getUserPrincipal().getName());
        simInfo.setEmployee(employee);
        simInfo.setOperator(operator);
        simInfo.setFunctioning(isFunctioning);
        simInfo.setCSD(CSD);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setHostName(hostname);
        simInfo.setHostName(request.getRemoteUser());
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfoService.save(simInfo);
        return "redirect:/";
    }
}
