package com.dj.photoapp.discovery.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dj.photoapp.discovery.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService {
	
	UserDto createUser(UserDto userDetails);
	
}
