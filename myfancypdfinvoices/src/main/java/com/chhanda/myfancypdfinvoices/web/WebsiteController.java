package com.chhanda.myfancypdfinvoices.web;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chhanda.myfancypdfinvoices.web.forms.LoginForm;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
@Controller
public class WebsiteController {

	@GetMapping("/")
	public String homePage(Model model,@RequestParam(required=false,defaultValue = "Stranger") String username) {		
		model.addAttribute("username", username);
        model.addAttribute("currentDate", new Date());
		return "index.html";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute @Valid LoginForm loginForm,BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "login.html";
		}
		
		if(loginForm.getUsername().equalsIgnoreCase(loginForm.getPassword())) {
			//model.addAttribute("username", loginForm.getUsername());
			return "redirect:/";
		}
		model.addAttribute("invalidCredentials", true);		
		return "login.html";		
	}
}	
