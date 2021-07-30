package com.boa.appointmentapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.appointmentapi.models.Appointment;

public interface SaveAppointmentRepository extends MongoRepository<Appointment, Long>{

}
