package com.spring.tutorial.services;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by thandomafela on 03/04/2016.
 */
@Component(value = "appointmentBookService")
public class AppointmentBookService {


    public List<String> getAllAppointments() {
        String [] list = { "Monday", "Tuesday", "Wednesday"};
        return Arrays.asList(list);
    }
}
