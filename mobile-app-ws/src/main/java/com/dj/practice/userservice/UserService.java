package com.dj.practice.userservice;

import com.dj.practice.ui.model.request.UserDetailsRequestModel;
import com.dj.practice.ui.model.response.UserRest;


public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);
}
