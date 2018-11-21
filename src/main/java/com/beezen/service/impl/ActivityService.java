package com.beezen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beezen.domain.Activity;
import com.beezen.exeption.CustomException;
import com.beezen.repository.ActivityRepo;
import com.beezen.service.IActivityService;

@Service
public class ActivityService implements IActivityService {

	
	@Autowired
	private ActivityRepo repo;

	@Override
	public Iterable<Activity> findAll() {
		return repo.findAll();
	}

	@Override
	public Activity save(Activity a) throws CustomException {
		return repo.save(a);
	}

	@Override
	public Activity findOne(Long id) {
		Optional<Activity> optional = repo.findById(id);
		Activity activity = optional.get();
		return activity;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Activity> findAllByValid(boolean valid) {
	
		return repo.findByIsValid(valid);
	}

}
