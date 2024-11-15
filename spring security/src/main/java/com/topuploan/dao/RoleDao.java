package com.topuploan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topuploan.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String> 
{


}
