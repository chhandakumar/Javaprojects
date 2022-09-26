package com.fedex.rest.webservices.restfulwebservices.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<Application, Long>{
	List<Application> findByUsername(String username);
}
