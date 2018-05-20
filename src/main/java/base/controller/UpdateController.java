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

    @RequestMapping("/update")
    public String update(HttpServletRequest request,
                         @RequestParam("id") long id,
                         @RequestParam("location") String location,
                         @RequestParam("employee") String employee,
                         @RequestParam(value = "functioning", required = false) boolean functioning,
                         @RequestParam(value = "CSD", required = false) boolean CSD) {
        SimInfo simInfo = simInfoService.getById(id);
        simInfo.setLastLocation(simInfo.getCurLocation());
        simInfo.setCurLocation(location);
        //simInfo.setEmployeeSurname(request.getUserPrincipal().getName());
        simInfo.setEmployeeSurname(employee);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfo.setCSD(CSD);
        simInfo.setFunctioning(functioning);
        simInfoService.save(simInfo);
        return "redirect:/all";
    }
}
