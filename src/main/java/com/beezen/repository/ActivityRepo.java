package com.beezen.repository;

import org.springframework.data.repository.CrudRepository;
import com.beezen.domain.Activity;

public interface ActivityRepo extends CrudRepository<Activity, Long> {

}
