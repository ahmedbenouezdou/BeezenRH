package com.beezen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beezen.domain.Roles;
import com.beezen.repository.RolesRepo;
import com.beezen.service.IRolesService;


@Service
public class RolesService implements IRolesService {

	@Autowired
	private RolesRepo repo;

	@Override
	public List<Roles> getAllRoles() {
		return (List<Roles>) repo.findAll();
	}
}
