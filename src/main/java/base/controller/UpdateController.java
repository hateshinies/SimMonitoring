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
                         @RequestParam("id") Long id,
                         @RequestParam(name = "ed_operator", required = false) String operator,
                         @RequestParam(name = "ed_curLocation", required = false) String curLocation,
                         @RequestParam(name = "ed_employee", required = false) String employee,
                         @RequestParam(value = "ed_functioning", required = false) boolean functioning,
                         @RequestParam(value = "ed_CSD", required = false) boolean CSD) {
        SimInfo simInfo = simInfoService.findSimInfoById(id);
        if (simInfo == null) return "redirect:/error";
        System.out.println("phoneId = " + id);
        simInfo.setLastLocation(simInfo.getCurLocation());
        if (!curLocation.isEmpty())
            simInfo.setCurLocation(curLocation);
        //simInfo.setEmployeeSurname(request.getUserPrincipal().getName());
        if (!employee.isEmpty())
            simInfo.setEmployeeSurname(employee);
        if (!operator.isEmpty())
            simInfo.setOperator(operator);
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfo.setCSD(CSD);
        simInfo.setFunctioning(functioning);
        simInfoService.save(simInfo);
        return "redirect:/all";
    }
}
