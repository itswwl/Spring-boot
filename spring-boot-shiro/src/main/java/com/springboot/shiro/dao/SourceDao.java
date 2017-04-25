package com.springboot.shiro.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.shiro.entry.Sources;

@Repository
public interface SourceDao extends BaseDao<Sources, Long> {
	
	@Query(" from Sources s where s.id in (:sids) and s.type = :type ")
	public Set<Sources> findBySourceIDS(@Param("sids")Set<Long> sids,@Param("type")Integer type);
	
	@Query(" from Sources s where s.id in (:sids) ")
	public Set<Sources> findBySourceIDS(@Param("sids")Set<Long> sids);

}
