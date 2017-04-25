package com.springboot.shiro.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.shiro.entry.Roles;

@Repository
public interface RolesDao extends BaseDao<Roles, Long> {
	
	@Query(" from Roles r where r.id in (:ids) ")
	public Set<Roles> findByIDS(@Param("ids")Set<Long> ids);
	
}
