package base.controller;

import base.domain.SimInfo;
import base.service.SimInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UpdateController {

    @Autowired
    private SimInfoService simInfoService;

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable Long id, @RequestHeader("host")
            String hostname, HttpServletRequest request){
        SimInfo simInfo = simInfoService.getById(id);
        simInfo.setLastLocation(simInfo.getCurLocation());
        simInfo.setCurLocation("   ");
        simInfo.setEmployeeSurname("   ");
        simInfo.setLastChangeDate(new Timestamp(new Date().getTime()));
        simInfo.setHostName(hostname);
        simInfo.setHostName(request.getRemoteUser());
        simInfo.setIpAddress(request.getRemoteAddr());
        simInfo.setFunctioning(true);
        simInfo.setOperator(" ");
        simInfoService.save(simInfo);
        return "editEntry";
    }
}
