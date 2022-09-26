package com.fedex.rest.webservices.restfulwebservices.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ApplicationHardcodedService {
	
	private static List<Application> applications = new ArrayList<>();
	private static long idCounter = 0;
	
	static {
		applications.add(new Application(++idCounter, "fedex","EAI - 6791", new Date(), false ));
		applications.add(new Application(++idCounter, "fedex","EAI - 3531330", new Date(), false ));
		applications.add(new Application(++idCounter, "fedex","EAI - 3535182", new Date(), false ));
	}
	
	public List<Application> findAll() {
		return applications;
	}

	public Application save(Application application) {
		if(application.getId()==-1 || application.getId()==0) {
			application.setId(++idCounter);
			applications.add(application);
		} else {
			deleteById(application.getId());
			applications.add(application);
		}
		return application;
	}
	
	public Application deleteById(long id) {
		Application application = findById(id);
		
		if(application==null) return null;
		
		if(applications.remove(application)) {
			return application;
		}
		
		return null;
	}

	public Application findById(long id) {
		for(Application application:applications) {
			if(application.getId() == id) {
				return application;
			}
		}
		
		return null;
	}
	
}
