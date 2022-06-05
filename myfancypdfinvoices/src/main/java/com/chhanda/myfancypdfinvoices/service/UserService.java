package com.chhanda.myfancypdfinvoices.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chhanda.myfancypdfinvoices.model.User;

@Component
public class UserService {

	public User findById(String id) {
		
		String randomName = UUID.randomUUID().toString();
		return new User(id,randomName);
	}
}
