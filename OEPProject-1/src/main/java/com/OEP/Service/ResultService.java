package com.OEP.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.Result;
import com.OEP.Repository.ResultRepo;

@Service

@Transactional
public class ResultService {
	@Autowired
	ResultRepo repo;

	public Result addResultDetails(Result r) {
		return repo.save(r);
	}

}
