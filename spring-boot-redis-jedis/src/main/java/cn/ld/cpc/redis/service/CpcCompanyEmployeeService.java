package cn.ld.cpc.redis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ld.cpc.redis.dao.CpcCompanyEmployeeDao;
import cn.ld.cpc.redis.model.sys.CpcCompanyEmployee;
import cn.ld.cpc.redis.model.sys.RedisTempleteUtil;

@Service
public class CpcCompanyEmployeeService {
	
	private static final Logger logger = Logger.getLogger(CpcCompanyEmployeeService.class);
	
	@Autowired
	private CpcCompanyEmployeeDao cpcCompanyEmployeeDao;
	
	@Autowired
	private RedisTempleteUtil redisTempleteUtil;
	
	@Transactional(rollbackFor
			= {Exception.class})
	public CpcCompanyEmployee save(CpcCompanyEmployee cpcCompanyEmployee){
		try {
			return cpcCompanyEmployeeDao.save(cpcCompanyEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
		
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public List<CpcCompanyEmployee> saveList(List<CpcCompanyEmployee> list){
		try {
			return (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.save(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public CpcCompanyEmployee update(Long id){
		try {
			CpcCompanyEmployee cpcCompanyEmployee = cpcCompanyEmployeeDao.findOne(id);
			cpcCompanyEmployee.setRealName("张三");
			cpcCompanyEmployee.setIdCardNo("1111111111");
			
			CpcCompanyEmployee object = (CpcCompanyEmployee) redisTempleteUtil.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindById"+id);
			
			
			logger.info("========================================================");
			logger.info(object.toString());
			logger.info("========================================================");
			
			redisTempleteUtil.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindById"+id, cpcCompanyEmployee);
			return cpcCompanyEmployeeDao.save(cpcCompanyEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
		
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public List<CpcCompanyEmployee> updateList(List<Long> list){
		try {
			List<CpcCompanyEmployee> lists = (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.findAll(list);
			for (CpcCompanyEmployee cpcCompanyEmployee : lists) {
				if(cpcCompanyEmployee.getId() == 200000000L){
					cpcCompanyEmployee.setRealName("李四");
					cpcCompanyEmployee.setIdCardNo("2222222222");
				}
				if(cpcCompanyEmployee.getId() == 300000000L){
					cpcCompanyEmployee.setRealName("王无");
					cpcCompanyEmployee.setIdCardNo("3333333333");
				}
				
			}
			@SuppressWarnings("unchecked")
			List<CpcCompanyEmployee> object = (List<CpcCompanyEmployee>) redisTempleteUtil.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindList[200000000, 300000000]");
			
			logger.info("========================================================");
			
			logger.info(object.toString());
			
			logger.info("========================================================");
			
			redisTempleteUtil.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindList[200000000, 300000000]", lists);
			return (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.save(lists);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Cacheable(value = "findById",keyGenerator = "wiselyKeyGenerator") 
	@Transactional(readOnly = true)
	public CpcCompanyEmployee findById(Long id){
		try {
			logger.info("CpcCompanyEmployeeService----->findById()不执行缓存");
			return cpcCompanyEmployeeDao.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Cacheable(value = "findList",keyGenerator = "wiselyKeyGenerator")
	@Transactional(readOnly = true)
	public List<CpcCompanyEmployee> findList(List<Long> list){
		try {
			logger.info("CpcCompanyEmployeeService----->findList()不执行缓存");
			return (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.findAll(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Cacheable(value = "page",keyGenerator = "wiselyKeyGenerator")
	@Transactional(readOnly = true)
	public /*Page<CpcCompanyEmployee>*/List<CpcCompanyEmployee> page(Map<String,Object> map){
		try {
			logger.info("CpcCompanyEmployeeService----->page()不执行缓存");
			List<Sort.Order> orders = new ArrayList<>();
			orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
			
			Sort sort = new Sort(orders);
			
			Pageable pageable = new PageRequest(0, 10, sort);
			
			
			return cpcCompanyEmployeeDao.findAll(new Specification<CpcCompanyEmployee>() {
				
				@Override
				public Predicate toPredicate(Root<CpcCompanyEmployee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Predicate predicate = cb.conjunction();
//					Map param = (Map)map.get("param");
//					Object degree = param.get("degree");
//					if(degree !=null){
//						predicate.getExpressions().add(cb.like(root.<String>get("schoolNameText"),"%"+degree.toString()+"%"));
//					}
					return predicate;
				}
			}, pageable).getContent();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	//@CacheEvict(value = "findById" , allEntries = true)
	@Transactional(rollbackFor = {Exception.class})
	public void delte(Long id){
		try {
			cpcCompanyEmployeeDao.delete(id);
			
			redisTempleteUtil.remove("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindById"+id);
			redisTempleteUtil.remove("findById~keys");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public void deleteList(List<Long> list){
		try {
			List<CpcCompanyEmployee> lists = (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.findAll(list);
		    cpcCompanyEmployeeDao.delete(lists);
		    
		    
		    redisTempleteUtil.remove("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindList[200000000, 300000000]");
		    redisTempleteUtil.remove("findList~keys");
		    
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}

}
