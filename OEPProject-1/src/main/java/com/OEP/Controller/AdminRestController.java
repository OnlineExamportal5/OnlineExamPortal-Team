package com.OEP.Controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OEP.Exceptions.ResourceNotFoundException;
import com.OEP.Model.Admin;
import com.OEP.Model.Users;
import com.OEP.Service.AdminService;

@RestController
@RequestMapping("/AdminPage")
public class AdminRestController {
	@Autowired
	AdminService service;

	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@Validated @RequestBody Admin e) {
		Admin emp = service.addAdmin(e);
		return new ResponseEntity<String>("Registration done successfully", HttpStatus.OK);
	}

	@GetMapping("/AdminLogin")
	public ResponseEntity<String> checkAdmin(@RequestBody Admin ad) {
		String status = null;
		Admin obj = service.login(ad.getName(), ad.getPassword());
		if (Objects.nonNull(obj)) {
			status = "Welcome to the portal";
		} else {
			throw new ResourceNotFoundException("Invalid Credentials");
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@PutMapping("/updateAdminById")
	public ResponseEntity<String> updateAdminById(@Validated @RequestBody Admin ad) {
		String status = null;
		Optional<Admin> obj = service.findById(ad.getId());
		obj.get().setEmailid(ad.getEmailid());

		if (obj.isPresent()) {
			service.updateAdminById(obj.get());
			status = "Successfully Updated";
		} else {

			status = "Id is not available";
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		System.out.println(id);
		service.deleteById(id);

		return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Validated @RequestBody Users u) {
		Users us = service.addUser(u);

		return new ResponseEntity<String>("record inserted successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteByName/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name) {
		System.out.println(name);
		service.deleteByname(name);

		return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
	}
}
