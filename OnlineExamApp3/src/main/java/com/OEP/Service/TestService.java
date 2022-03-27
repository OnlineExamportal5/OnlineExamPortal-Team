package com.OEP.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.TestPage;
import com.OEP.Repository.TestRepo;

@Service
@Transactional
public class TestService {
	@Autowired
	TestRepo repo;

	public TestPage addTest(TestPage t) {
		TestPage test=repo.save(t);
		return test;
	}

	public Optional<TestPage> findBytestId(int testId) {
		return repo.findBytestId(testId);
	}

	public void updateTestById(TestPage test) {
		repo.save(test);
		
	}

	public void deleteById(int testId) {
		repo.deleteById(testId);
		
	}

}
