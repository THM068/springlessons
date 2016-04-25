package com.spring.tutorial.controllers;

import com.spring.tutorial.services.AppointmentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by thandomafela on 02/04/2016.
 */
@Controller
public class HomeController {

    private final AppointmentBookService appointmentBookService;

    @Autowired
    public HomeController(AppointmentBookService appointmentBookService) {
        this.appointmentBookService = appointmentBookService;
    }


    @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Hello World!");
        return "helloWorld";
    }

    @RequestMapping(path = "/appointments/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", appointmentBookService.getAllAppointments());

        return Views.APPOINTMENT_LIST;
    }
}
