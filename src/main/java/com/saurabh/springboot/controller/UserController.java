package com.saurabh.springboot.controller;

import com.saurabh.springboot.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView renderCreateUserForm() {
        return new ModelAndView("user").addObject("user", new UserForm());
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") UserForm user) {
        return new ModelAndView("index").addObject("message", String.format("User: '%s' saved", user.getFirstName()));
    }

}
