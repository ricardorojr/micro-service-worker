package com.ricardo.payroll.services;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ricardo.payroll.entities.Payment;
import com.ricardo.payroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker-host}")
	private String WorkerHost;
	
	@Value("${hr-worker-path}")
	private String WorkerPath;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(WorkerHost + WorkerPath + "{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
