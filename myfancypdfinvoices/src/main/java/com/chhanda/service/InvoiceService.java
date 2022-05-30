package com.chhanda.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.chhanda.context.Application;
import com.chhanda.model.Invoice;
import com.chhanda.model.User;



public class InvoiceService {

	static List<Invoice> invoices = new CopyOnWriteArrayList<>();
	
	public List<Invoice> findAll(){
		return invoices;
	}
	
	private final UserService userService;
	
	public InvoiceService(UserService userService) {
		this.userService=userService;
	}
	
	public Invoice create(String userId,Integer amount) {
		
		User user = userService.findById(userId);
		if(user==null) {
			throw new IllegalStateException();
		}
		
		Invoice invoice = new Invoice(userId,amount,"http://www.africau.edu/images/default/sample.pdf");
		invoices.add(invoice);
		return invoice;
	}
}
