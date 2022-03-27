package com.OEP.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OEP.Model.TestPage;
@Repository
//@Transactional
public interface TestRepo extends JpaRepository<TestPage,Integer> {

	Optional<TestPage> findBytestId(int testId);
	public void deleteById(int testId);

}
