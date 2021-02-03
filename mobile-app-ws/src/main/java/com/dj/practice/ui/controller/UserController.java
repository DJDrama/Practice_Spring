package com.dj.practice.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dj.practice.ui.model.request.UpdateUserDetailsRequestModel;
import com.dj.practice.ui.model.request.UserDetailsRequestModel;
import com.dj.practice.ui.model.response.UserRest;
import com.dj.practice.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	Map<String, UserRest> users;
	
	@Autowired //will create instance (DI)
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "Get users was called! " + page + " " + limit + " " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		//if(true) throw new UserServiceException("User service exception thrown");
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {

		UserRest temp = users.get(userId);
		temp.setFirstName(userDetails.getFirstName());
		temp.setLastName(userDetails.getLastName());

		users.put(userId, temp);

		return temp;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
