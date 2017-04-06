package com.springboot.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.springboot.dao.BaseDao;

public class BaseDaoImpl implements BaseDao<Users, Integer> {

	public <S extends Users> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Users> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Users> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Users entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Users> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Iterable<Users> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count(Specification<Users> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Users> findAll(Specification<Users> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Users> findAll(Specification<Users> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> findAll(Specification<Users> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users findOne(Specification<Users> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
