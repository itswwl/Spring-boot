package com.springboot.shiro.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.shiro.entry.UserRole;

@Repository
public interface UserRoleDao extends BaseDao<UserRole, Long> {
	
	@Query(" from UserRole ur where ur.userid  = :uid ")
	public Set<UserRole> findRoleByUID(@Param("uid")Long uid);

}
