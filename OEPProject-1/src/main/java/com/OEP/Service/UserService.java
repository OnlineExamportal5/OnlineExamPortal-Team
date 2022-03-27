package com.OEP.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.Users;
import com.OEP.Repository.UserRepo;

@Service

@Transactional
public class UserService {

	@Autowired
	UserRepo repo;

	public Users addUsersDetails(Users u) {
		return repo.save(u);
	}

	public List<Users> findTestByUserIdAndPassword(int userId, String password) {
		return repo.findTestByUserIdAndPassword(userId, password);
	}

}
