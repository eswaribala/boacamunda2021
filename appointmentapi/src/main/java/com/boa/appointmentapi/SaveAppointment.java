package com.boa.appointmentapi;

import java.util.Map;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.boa.appointmentapi.models.Appointment;
import com.github.wnameless.json.flattener.JsonFlattener;

import spinjar.com.minidev.json.JSONObject;
import spinjar.com.minidev.json.parser.JSONParser;
@Component("saveAppointment")
public class SaveAppointment implements JavaDelegate{
    @Autowired
	private RestTemplate restTemplate;
	
    @Value("${appointmentUrl}")
    private String url;    
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		//invoke rest service
		Appointment appointment=new Appointment();
		appointment.setAppointmentId(new Random().nextInt(1000000));
        appointment.setCustomerId(Long.parseLong(execution.getVariable("customerId").toString()));  
        appointment.setDoa(execution.getVariable("doa").toString());
        appointment.setTime(execution.getVariable("time").toString());
        appointment.setReason(execution.getVariable("reason").toString());
		HttpHeaders headers = new HttpHeaders();
	       headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity request = new HttpEntity<>(appointment,headers);

		ResponseEntity<?> response=restTemplate.
	 		      postForEntity(url,request, String.class);

		Map<String,Object> data=parseString(response.getBody().toString());
		for(String key:data.keySet()) {
			System.out.println(data.get(key));
		}
				
	}
	
	private Map<String,Object> parseString(String response)
	{
		JSONParser parser = new JSONParser(); 
		Map<String, Object> flattenedJsonMap=null;
		String token="";
	  	try {
	  		 
			// Put above JSON content to crunchify.txt file and change path location
			Object obj = parser.parse(response);
			JSONObject jsonObject = (JSONObject) obj;
 
			// JsonFlattener: A Java utility used to FLATTEN nested JSON objects
			String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
			//log("\n=====Simple Flatten===== \n" + flattenedJson);
 
		flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
		 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return flattenedJsonMap;

	}


}
