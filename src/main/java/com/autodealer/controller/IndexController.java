package com.autodealer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ilshyma on 01.04.2016.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    protected ModelAndView start() throws Exception {
        log.info("enter hello controller");

        ModelAndView model = new ModelAndView("index");
        return model;
    }
}




