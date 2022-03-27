package com.OEP.Controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OEP.Exceptions.ResourceNotFoundException;
import com.OEP.Model.Users;
import com.OEP.Service.UserService;

@RestController
@RequestMapping("/Users")
public class UserRestController {

	@Autowired
	UserService service;

	@PostMapping("/addUserDetails")
	public ResponseEntity<Users> addUsersDetails(@Validated @RequestBody Users users) {
		Users u = service.addUsersDetails(users);
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}

	@GetMapping("/TestbyUserIdAndPassword")
	public ResponseEntity<List<Users>> findTestByUserIdAndPassword(@RequestParam int userId,

			@RequestParam String password) {
		String status = null;
		List<Users> users = service.findTestByUserIdAndPassword(userId, password);

		if (!users.isEmpty()) {
			status = "Successfully Opened the test content page";
		} else {
			throw new ResourceNotFoundException("Given userId and Password is not available");
		}

		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

	@GetMapping("/UserLogin")
	public ResponseEntity<String> checkUser(@RequestBody Users u) {
		String status = null;
		Users user = service.userlogin(u.getUserName(), u.getPassword());
		if (Objects.nonNull(user)) {
			status = "welcome to the portal";
		} else {
			throw new ResourceNotFoundException("Invaild Credentials");
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@PutMapping("/forgotPassword")
	public ResponseEntity<String> updateUserByEmailId(@RequestBody Users u) {
		String status = null;
		Optional<Users> obj = service.findByEmailId(u.getUserEmail());

		if (obj.isPresent()) {
			obj.get().setPassword(u.getPassword());
			service.updateUserByEmailId(obj.get());
			status = "Password Changed Successfully";
		} else {
			throw new ResourceNotFoundException("Provide Valid EmailId");

		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
