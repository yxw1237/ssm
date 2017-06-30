package com.cn.yuexw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.yuexw.dao.IUserDao;
import com.cn.yuexw.pojo.User;
import com.cn.yuexw.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}
