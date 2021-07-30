package com.boa.appointmentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.appointmentapi.models.Appointment;
import com.boa.appointmentapi.services.SaveAppointmentService;

@RestController
public class SaveAppointmentController {
    @Autowired
	private SaveAppointmentService saveAppointmentService;
    @PostMapping("/appointments")
    public ResponseEntity<?> saveAppointment(@RequestBody Appointment appointment){
    	
    	return ResponseEntity.status(HttpStatus.OK)
    			.body(saveAppointmentService.saveAppointmentDetails(appointment));
    }
} 
