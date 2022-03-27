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
import com.OEP.Model.UserPage;
import com.OEP.Service.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@Validated @RequestBody Admin a) {
		Admin ad = service.addAdmin(a);
		// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return new ResponseEntity<String>("record inserted successfully", HttpStatus.OK);
	}

	@PutMapping("/updateAdminById")
	public ResponseEntity<String> updateAdminById(@Validated @RequestBody Admin ad) {
		String status = null;

		Optional<Admin> obj = service.findById(ad.getId());
		obj.get().setEmail(ad.getEmail());

		// System.out.println(obj.get());

		if (obj.isPresent()) {
			service.updateAdminById(obj.get());
			status = "Successfully Updated";

		} else {
			// throw new ResourceNotFoundException("Given id its not available in db...");
			status = "Id is not available";
		}

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {

		System.out.println(id);

		service.deleteById(id);

		// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
	}

//////////////User//////////////
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Validated @RequestBody UserPage u) {
		UserPage us = service.addUser(u);
// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return new ResponseEntity<String>("record inserted successfully", HttpStatus.OK);
	}

	@GetMapping("/AdminLogin")
	public ResponseEntity<String> checkAdmin(@RequestBody Admin ad) {
		String status = null;
		Admin obj = service.login(ad.getName(), ad.getPassword());
		if (Objects.nonNull(obj)) {
			status = "welcome to the portal";

		} else {
			//throw new ResourceNotFoundException("InvalidCredentials...");
			 status="Invalid Credentials";
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByName/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name) {

		System.out.println(name);

		service.deleteByname(name);

		// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
	}

}
