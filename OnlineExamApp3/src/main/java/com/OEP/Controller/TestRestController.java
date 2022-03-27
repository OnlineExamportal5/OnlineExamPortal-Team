package com.OEP.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OEP.Exceptions.ResourceNotFoundException;
import com.OEP.Model.TestPage;
import com.OEP.Service.TestService;

@RestController
@RequestMapping("/Test")
public class TestRestController {
	@Autowired
	TestService service;
	
@PostMapping("/addTest")
public ResponseEntity<String> addTest(@Validated @RequestBody TestPage t) {
    TestPage test = service.addTest(t);
	// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	return new ResponseEntity<String>("record inserted successfully", HttpStatus.OK);
	}

@PutMapping("/updateTestById")
public ResponseEntity<String> updateTestBytestId(@Validated @RequestBody TestPage test) {
	String status = null;

	
	Optional<TestPage> obj = service.findBytestId(test.getTestId());
	//obj.get().setCourseType(test.getCourseType());

	//System.out.println(obj.get());
	
	if (obj.isPresent()) {
		service.updateTestById(obj.get());
		status = "Successfully Updated";

	} else {
		throw new ResourceNotFoundException("Given id its not available in db...");
		// status ="Id is not available";
	}

	return new ResponseEntity<String>(status, HttpStatus.OK);
}
@DeleteMapping("/deleteById/{testId}")
public ResponseEntity<String> deleteById(@PathVariable int testId) {

	System.out.println(testId);

	service.deleteById(testId);

	// return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
}

}
