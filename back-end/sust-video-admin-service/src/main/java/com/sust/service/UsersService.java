package com.sust.service;

import com.sust.pojo.Users;
import com.sust.utils.PagedResult;

public interface UsersService {

	public PagedResult queryUsers(Users user, Integer page, Integer pageSize);
	
}
