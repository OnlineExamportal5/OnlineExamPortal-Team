package com.OEP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OEP.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	List<Users> findTestByUserIdAndPassword(int userId, String password);

	void deleteByname(String name);
}
