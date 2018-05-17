package base.controller;

import javax.validation.Valid;

import base.domain.SimInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    //todo make this shit work
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView validateSimInfo(@Valid SimInfo simInfo, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView(new RedirectView("/error"));
        mv.addObject("SimInfo", simInfo);
        if (bindingResult.hasErrors())
            return new ModelAndView(new RedirectView("/error"));
        else
            return mv;
    }

}