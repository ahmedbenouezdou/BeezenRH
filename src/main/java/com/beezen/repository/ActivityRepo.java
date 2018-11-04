package com.beezen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.beezen.domain.Activity;

public interface ActivityRepo extends CrudRepository<Activity, Long> {

	public List<Activity> findByIsValid(boolean isValid);
}
