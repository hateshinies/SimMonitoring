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
    public String update(HttpServletRequest request, @RequestParam("Id") long id, @RequestParam("Location") String location,
                                @RequestParam(value = "isFunc", required=false) boolean isFunctioning,
                                @RequestParam(value = "isHasCsd", required=false) boolean isHasCsd) {
        SimInfo simInfo = simInfoService.getById(id);
        simInfo.setLastLocation(simInfo.getCurLocation());
        simInfo.setCurLocation(location);
        //simInfo.setEmployeeSurname(request.getUserPrincipal().getName());
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfo.setHaveCsd(isHasCsd);
        simInfo.setFunc(isFunctioning);
        simInfoService.save(simInfo);
        return "redirect:/";
    }
}
