package com.beezen.service;

import com.beezen.domain.Activity;
import com.beezen.exeption.CustomException;

public interface IActivityService {

	public Activity save(Activity a) throws CustomException;

	public Activity findOne(Long id);

	public void delete(Long id);

	public Iterable<Activity> findAll();
	
	public Iterable<Activity> findAllByValid(boolean valid);

}
