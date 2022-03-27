package com.exam.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Exception.ResourceNotFoundException;
import com.exam.Model.Admin;
import com.exam.Service.AdminService;

@RestController
@RequestMapping("/AdminPage")

public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@Validated @RequestBody Admin e) {
		Admin emp = service.addAdmin(e);
		System.out.println(emp);
		return new ResponseEntity<String>("Registration done successfully", HttpStatus.OK);

	}

	@GetMapping("/AdminLogin")
	public ResponseEntity<String> checkAdmin( @RequestBody Admin ad) {
		String status = null;
		Admin obj = service.login(ad.getName(), ad.getPassword());

		if (Objects.nonNull(obj)) {
			status = "Welcome to the portal";
		} else {
			throw new ResourceNotFoundException("Invalid Credentials");

		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/AdminLogin") public ResponseEntity<List<Admin>> checkAdmin
	 * (@Validated @RequestParam String name,@RequestParam String password) { String
	 * status = null; List<Admin> obj = service.findByNameAndPassword(name,
	 * password);
	 * 
	 * if (!obj.isEmpty()){ status = "Welcome to the portal"; } else { throw new
	 * ResourceNotFoundException("Invalid Credentials");
	 * 
	 * } return new ResponseEntity<List<Admin>>(obj, HttpStatus.OK); }
	 */

}
