package com.chhanda.myfancypdfinvoices.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chhanda.myfancypdfinvoices.dto.InvoiceDto;
import com.chhanda.myfancypdfinvoices.model.Invoice;
import com.chhanda.myfancypdfinvoices.service.InvoiceService;

@RestController
@Validated
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
    
	/*
	 * @PostMapping("/invoices") public Invoice
	 * createInvoice(@RequestParam("user_id") String
	 * username, @RequestParam @Min(10) @Max(50) Integer amount) { return
	 * invoiceService.create(username, amount); }
	 */
    
}
