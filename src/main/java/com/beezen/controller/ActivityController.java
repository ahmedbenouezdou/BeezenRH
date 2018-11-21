package com.beezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beezen.domain.Activity;
import com.beezen.exeption.CustomException;
import com.beezen.exeption.NonAuthorizedException;
import com.beezen.exeption.NotFoundExeption;
import com.beezen.service.IActivityService;

import javassist.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {

	
	@Autowired
	private IActivityService activityService;

	@PutMapping
	public Activity save(@RequestBody Activity activity) throws CustomException {
		try {
			activity = activityService.save(activity);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new CustomException("message.erreur");
		}
		return activity;
	}

	@DeleteMapping
	public void deleteActivity(Long id) throws CustomException{
		try {
			activityService.delete(id);
	} catch (org.springframework.dao.DataIntegrityViolationException e) {
		throw new CustomException("message.erreur");
	}
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Activity> getAll()
			throws NotFoundExeption{
		try {
			List<Activity> acts = (List<Activity>) activityService.findAll();
			return acts;	
		}catch (Exception e) {
		throw new NotFoundExeption();
		}
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Activity getActivityParId(@PathVariable("id") Long id) throws NotFoundException, NonAuthorizedException {
		Activity act = activityService.findOne(id);
		return act;

	}

	@RequestMapping(value = "/getallvalid/{valid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Activity> getAllvalid(@PathVariable("valid") boolean valid)
			throws NotFoundExeption{
		try {
			List<Activity> acts = (List<Activity>) activityService.findAllByValid(valid);
			return acts;	
		}catch (Exception e) {
		throw new NotFoundExeption();
		}
	}
	
}
