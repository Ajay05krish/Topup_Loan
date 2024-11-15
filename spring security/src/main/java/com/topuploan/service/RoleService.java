package com.topuploan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topuploan.dao.RoleDao;
import com.topuploan.entity.Role;

@Service
public class RoleService 
{
	@Autowired
	private RoleDao roleDao;
	public Role createNewRole(Role role)
	{
		return roleDao.save(role);
	}
}
