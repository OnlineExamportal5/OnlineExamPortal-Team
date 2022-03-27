package com.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exam.Model.Address;
import com.exam.Model.Admin;
import com.exam.Repo.AdminRepo;
import com.exam.Service.AdminService;


@SpringBootTest
public class AdminTest {

	@MockBean
	private AdminRepo repo;

	@Autowired
	private AdminService service;

	@Test
	public void saveAdmin() {
		Address address = new Address("2nd street", "varkala", "kerala", "1256");
		Admin insert = new Admin("akka", "akka@gmail.com", "12aA", 123, address);
		when(repo.save(insert)).thenReturn(insert);
		assertEquals(insert, service.addAdmin(insert));
	}

	@Test
	public void getNameAndPassword() {
		String name = "adams";
		String password = "12aA";
		Address address = new Address("2nd street", "varkala", "kerala", "1256");
		
		Admin insert = new Admin("adams", "akka@gmail.com", "12aA", 123, address);
		when(repo.findByNameAndPassword(name, password)).thenReturn(insert);
		assertEquals(insert,service.login(name, password));
		
	}

}
