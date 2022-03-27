package com.OEP.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.Address;
import com.OEP.Repository.AddressRepo;

@Service

@Transactional
public class AddressService {
	@Autowired
	AddressRepo repo;

	public Address addAddress(Address a) {
		return repo.save(a);
	}

}
