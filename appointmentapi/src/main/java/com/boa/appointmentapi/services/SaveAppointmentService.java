package com.boa.appointmentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.appointmentapi.models.Appointment;
import com.boa.appointmentapi.repositories.SaveAppointmentRepository;

@Service
public class SaveAppointmentService {
    @Autowired
	private SaveAppointmentRepository saveAppointmentRepository;
    
    public Appointment saveAppointmentDetails(Appointment appointment) {
    	return this.saveAppointmentRepository.save(appointment);
    }
}
