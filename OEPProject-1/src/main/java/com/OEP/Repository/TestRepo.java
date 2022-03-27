package com.OEP.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OEP.Model.Tests;

@Repository
public interface TestRepo extends JpaRepository<Tests, Integer> {

	List<Tests> findResultBytestId(int testId);

	Optional<Tests> findBytestId(int testId);
	

}
