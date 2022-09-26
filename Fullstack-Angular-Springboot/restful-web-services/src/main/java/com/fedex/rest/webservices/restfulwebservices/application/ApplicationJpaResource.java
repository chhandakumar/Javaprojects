package com.fedex.rest.webservices.restfulwebservices.application;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fedex.rest.webservices.restfulwebservices.application.Application;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ApplicationJpaResource {
	
	@Autowired
	private ApplicationHardcodedService applicationService;

	@Autowired
	private ApplicationJpaRepository applicationJpaRepository;

	
	@GetMapping("/jpa/users/{username}/applications")
	public List<Application> getAllapplications(@PathVariable String username){
		return applicationJpaRepository.findByUsername(username);
		//return applicationService.findAll();
	}

	@GetMapping("/jpa/users/{username}/applications/{id}")
	public Application getapplication(@PathVariable String username, @PathVariable long id){
		return applicationJpaRepository.findById(id).get();
		//return applicationService.findById(id);
	}

	//DELETE /users/{username}/applications/{id}
	@DeleteMapping("/jpa/users/{username}/applications/{id}")
	public ResponseEntity<Void> deleteapplication(
			@PathVariable String username, @PathVariable long id){
		
		//application application = applicationService.deleteById(id);
		applicationJpaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		//return ResponseEntity.notFound().build();
	}
	

	//Edit/Update a application
	//PUT /users/{user_name}/applications/{application_id}
	@PutMapping("/jpa/users/{username}/applications/{id}")
	public ResponseEntity<Application> updateapplication(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Application application){
		
		//application applicationUpdated = applicationService.save(application);
		Application applicationUpdated = applicationJpaRepository.save(application);
		
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/applications")
	public ResponseEntity<Void> createapplication(
			@PathVariable String username, @RequestBody Application application){
		
		//application createdapplication = applicationService.save(application);
		application.setUsername(username);
		Application createdapplication = applicationJpaRepository.save(application);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdapplication.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}
