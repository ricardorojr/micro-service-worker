package com.ricardo.payroll.services;

import org.springframework.stereotype.Service;

import com.ricardo.payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Ricardo", 200.0, days);
	}
}
