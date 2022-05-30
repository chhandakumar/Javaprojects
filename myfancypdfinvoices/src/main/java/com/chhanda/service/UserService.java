package com.chhanda.service;

import java.util.UUID;

import com.chhanda.model.User;

public class UserService {

	public User findById(String id) {
		
		String randomName = UUID.randomUUID().toString();
		return new User(id,randomName);
	}
}
