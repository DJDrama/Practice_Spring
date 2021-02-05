package com.dj.photoapp.discovery.api.users.service;

import java.util.UUID;

import com.dj.photoapp.discovery.api.users.shared.UserDto;

public class UsersServiceImpl implements UsersService {

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
