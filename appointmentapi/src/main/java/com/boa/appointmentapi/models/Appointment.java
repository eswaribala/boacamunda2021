package com.boa.appointmentapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "appointments")
@Data
public class Appointment {
    @Id
	private long appointmentId;
	private long customerId;
	private String doa;
	private String time;
	private String reason;
}
