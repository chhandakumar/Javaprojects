package com.chhanda.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.chhanda.myfancypdfinvoices.model.Invoice;
import com.chhanda.myfancypdfinvoices.model.User;


@Component
public class InvoiceService {

	static List<Invoice> invoices = new CopyOnWriteArrayList<>();
	
	public List<Invoice> findAll(){
		return invoices;
	}
	
	private  UserService userService;
	private String cdnUrl;
	
	public InvoiceService(UserService userService,@Value("${cdn.url}") String cdnUrl) {
		this.userService=userService;
		this.cdnUrl=cdnUrl;
	}

	@PostConstruct
	public void init() {
		System.out.println("Fetching PDF Template from S3...");
	}
	
	@PreDestroy
	public void shutdown() {
	    System.out.println("Deleting downloaded templates...");
	}
	
	public Invoice create(String userId,Integer amount) {
		
		User user = userService.findById(userId);
		if(user==null) {
			throw new IllegalStateException();
		}
		
		Invoice invoice = new Invoice(userId,amount,cdnUrl+"/images/default/sample.pdf");
		invoices.add(invoice);
		return invoice;
	}
}
