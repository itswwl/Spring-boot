package com.springboot.shiro.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.shiro.entry.RoleSource;
@Repository
public interface RoleSourceDao extends BaseDao<RoleSource, Long> {
	
	@Query(" from RoleSource rs where rs.roleid in (:rids) ")
	public Set<RoleSource> findSourceByRoleIDs(@Param("rids")Set<Long> rids);

}
