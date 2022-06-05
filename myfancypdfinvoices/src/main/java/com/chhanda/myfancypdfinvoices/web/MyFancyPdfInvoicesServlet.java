package com.chhanda.myfancypdfinvoices.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chhanda.myfancypdfinvoices.context.MyFancyPdfInvoicesApplicationConfiguration;
import com.chhanda.myfancypdfinvoices.model.Invoice;
import com.chhanda.myfancypdfinvoices.service.InvoiceService;
import com.chhanda.myfancypdfinvoices.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyFancyPdfInvoicesServlet extends HttpServlet {

	private UserService userService;
	private InvoiceService invoiceService;
	private ObjectMapper objectMapper;
	
	@Override
	public void init() throws ServletException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyFancyPdfInvoicesApplicationConfiguration.class);			
		
		ctx.registerShutdownHook();
		
		this.userService = ctx.getBean(UserService.class);
		this.invoiceService = ctx.getBean(InvoiceService.class);
		this.objectMapper = ctx.getBean(ObjectMapper.class);

	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/invoices")) {

            String userId = request.getParameter("user_id");
            Integer amount = Integer.valueOf(request.getParameter("amount"));

            Invoice invoice = invoiceService.create(userId, amount);

            response.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(invoice);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices = invoiceService.findAll();  // 
            response.getWriter().print(objectMapper.writeValueAsString(invoices));  // 
        }
    }
}