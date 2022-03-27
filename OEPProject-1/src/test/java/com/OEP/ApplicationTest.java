package com.OEP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.OEP.Model.Address;
import com.OEP.Model.Users;
import com.OEP.Repository.UserRepo;
import com.OEP.Service.UserService;

@SpringBootTest
public class ApplicationTest {
	@MockBean
	private UserRepo repo;

	@Autowired
	private UserService service;

	@Test
	public void findTestByUserIdAndPassword() {
		int userId = 20;
		String password = "Neha123";
		when(repo.findTestByUserIdAndPassword(userId, password))
				.thenReturn(Stream.of(new Users(123, "Neha123")).collect(Collectors.toList()));
		assertEquals(1, service.findTestByUserIdAndPassword(userId, password).size());
	}

	@Test
	public void saveUser() {
		Address address = new Address(125, "Kerala", 570007, "India");
		Users user = new Users(12, "Sara", "Sara123@gmail.com", "Sara123", 916465212, address);
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.addUsersDetails(user));
	}
	
	@Test

	public void getUserTest() {
	String name = "java";
	String password = "java009";
	Address address = new Address("HYD","TS","IND",001122);
	
	Users insert = new Users("ram","ram@gmail.com",1212345678,"ram009",address);
	when(repo.findByNameAndPassword(name,password)).thenReturn(insert);
	assertEquals(insert, service.userlogin(name,password));


	}

}
