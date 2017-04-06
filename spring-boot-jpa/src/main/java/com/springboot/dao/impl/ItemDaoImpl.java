package com.springboot.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.ItemDao;

@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Map<String,Object>> findAll() {
		String sql = "select id as id , name as name from item";
		Query query = entityManager.createNativeQuery(sql);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list = query.getResultList();
		return list;
	}

	public List<Map<String, Object>> findAll(Integer page, Integer rows) {
		int start = ((page - 1) * rows) + 1;
		int end = start + rows -1;
		String sql = "SELECT i.id as id,i.name as name FROM (SELECT tt.*, ROWNUM AS rowno "
				+ " FROM (  SELECT t.* FROM item t ORDER BY id) tt WHERE ROWNUM <= "+ end +") i  WHERE i.rowno >= "+start;
		Query query = entityManager.createNativeQuery(sql);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list = query.getResultList();
		return list;
	}

}
