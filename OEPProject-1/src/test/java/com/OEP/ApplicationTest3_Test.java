package com.OEP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.OEP.Model.Tests;
import com.OEP.Repository.TestRepo;
import com.OEP.Service.TestService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest3_Test {
	@MockBean
	private TestRepo repository;
	@Autowired
	private TestService service;

	@Test
	public void saveTest() {
		Tests test = new Tests(12, "maphysics");
		when(repository.save(test)).thenReturn(test);
		assertEquals(test, service.addTestDetails(test));
	}
	
}

