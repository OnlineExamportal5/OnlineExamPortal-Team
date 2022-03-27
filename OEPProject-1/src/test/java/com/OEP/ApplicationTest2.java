package com.OEP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.OEP.Model.Address;
import com.OEP.Model.Admin;
import com.OEP.Repository.AdminRepo;
import com.OEP.Service.AdminService;

@SpringBootTest
public class ApplicationTest2 {
	@MockBean
	private AdminRepo repo;
	@Autowired
	private AdminService service;

	@Test
	public void saveAdmin() {
		Address address = new Address(12, "2nd street", "varkala", "kerala", 1256);
		Admin insert = new Admin(23, "akka", "akka@gmail.com", "12aA", 123, address);
		when(repo.save(insert)).thenReturn(insert);
		assertEquals(insert, service.addAdmin(insert));
	}

	@Test
	public void getNameAndPassword() {
		String name = "adams";
		String password = "12aA";
		Address address = new Address(12, "2nd street", "varkala", "kerala", 1256);
		Admin insert = new Admin(34, "adams", "akka@gmail.com", "12aA", 123, address);
		when(repo.findByNameAndPassword(name, password)).thenReturn(insert);
		assertEquals(insert, service.login(name, password));
	}
}
