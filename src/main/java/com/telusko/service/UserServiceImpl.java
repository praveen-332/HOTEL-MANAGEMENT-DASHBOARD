package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.UserDao;
import com.telusko.model.User;



@Service
@Component
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userDao = userdao;
	}

	@Override
	public List<User> listAllUsers() {
		return userDao.listAllUsers();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
		
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}
	

}
