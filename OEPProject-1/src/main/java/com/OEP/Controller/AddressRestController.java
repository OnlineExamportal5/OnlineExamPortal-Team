package com.OEP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OEP.Model.Address;
import com.OEP.Service.AddressService;

@RestController
public class AddressRestController {
	@Autowired
	AddressService service;

	@PostMapping("/Address/addAddressDetails")
	public ResponseEntity<Address> addAddressDetails(@RequestBody Address address) {
		Address a = service.addAddress(address);
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}

}
