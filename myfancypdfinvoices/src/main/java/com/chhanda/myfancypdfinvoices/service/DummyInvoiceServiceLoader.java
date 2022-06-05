package com.chhanda.myfancypdfinvoices.service;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyInvoiceServiceLoader {

	private final InvoiceService invoiceService;
	
	 
	public DummyInvoiceServiceLoader (InvoiceService invoiceService) {
		this.invoiceService=invoiceService;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Creating dev invoices...");
		 invoiceService.create("someUserId", 50);
	     invoiceService.create("someOtherUserId", 100);
	}
}
