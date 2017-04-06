package cn.ld.cpc.redis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ld.cpc.redis.dao.CpcCompanyEmployeeDao;
import cn.ld.cpc.redis.model.sys.CpcCompanyEmployee;
import cn.ld.cpc.redis.model.sys.RedisClient;

@Service
public class CpcCompanyEmployeeServiceJedis {
	
	private static final Logger logger = Logger.getLogger(CpcCompanyEmployeeServiceJedis.class);
	
	@Autowired
	private CpcCompanyEmployeeDao cpcCompanyEmployeeDao;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisClient redisClient;
	
	@Transactional(rollbackFor
			= {Exception.class})
	public CpcCompanyEmployee save(CpcCompanyEmployee cpcCompanyEmployee){
		try {
			CpcCompanyEmployee employee = cpcCompanyEmployeeDao.save(cpcCompanyEmployee);
			@SuppressWarnings("unchecked")
			String str = redisClient.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.save", employee);
			logger.info(str);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
		
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public List<CpcCompanyEmployee> saveList(List<CpcCompanyEmployee> list){
		try {
			List<CpcCompanyEmployee> l = (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.save(list);
			@SuppressWarnings("unchecked")
			String str = redisClient.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.saveList", l);
			logger.info(str);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = {Exception.class})
	public CpcCompanyEmployee update(Long id){
		try {
			CpcCompanyEmployee cpcCompanyEmployee = cpcCompanyEmployeeDao.findOne(id);
			cpcCompanyEmployee.setRealName("张三");
			cpcCompanyEmployee.setIdCardNo("1111111111");
			
			CpcCompanyEmployee object = (CpcCompanyEmployee) redisClient.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.save", CpcCompanyEmployee.class);
			
			
			logger.info("========================================================");
			logger.info(object.toString());
			logger.info("========================================================");
			cpcCompanyEmployee = cpcCompanyEmployeeDao.save(cpcCompanyEmployee);
			redisClient.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.save", cpcCompanyEmployee);
			return cpcCompanyEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
		
	}
	
	@SuppressWarnings("unchecked")
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
			List<CpcCompanyEmployee> object = (List<CpcCompanyEmployee>) redisClient.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.saveList",List.class);
			
			logger.info("========================================================");
			
			logger.info(object.toString());
			
			logger.info("========================================================");
			lists = (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.save(lists);
			redisClient.set("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.saveList", lists);
			return lists;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	//@Cacheable(value = "findById",keyGenerator = "wiselyKeyGenerator") 
	@Transactional(readOnly = true)
	public CpcCompanyEmployee findById(Long id){
		try {
			logger.info("CpcCompanyEmployeeService----->findById()不执行缓存");
			
			@SuppressWarnings("unchecked")
			CpcCompanyEmployee object = (CpcCompanyEmployee) redisClient.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.save", CpcCompanyEmployee.class);
			
			
			logger.info("========================================================");
			logger.info(object.toString());
			logger.info("========================================================");
			
			return cpcCompanyEmployeeDao.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	//@Cacheable(value = "findList",keyGenerator = "wiselyKeyGenerator")
	@Transactional(readOnly = true)
	public List<CpcCompanyEmployee> findList(List<Long> list){
		try {
			logger.info("CpcCompanyEmployeeService----->findList()不执行缓存");
			@SuppressWarnings("unchecked")
			List<CpcCompanyEmployee> object = (List<CpcCompanyEmployee>) redisClient.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.saveList",List.class);
			
			logger.info("========================================================");
			
			logger.info(object.toString());
			
			logger.info("========================================================");
			return (List<CpcCompanyEmployee>) cpcCompanyEmployeeDao.findAll(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}
	
	@Cacheable(value = "page",keyGenerator = "wiselyKeyGenerator")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public /*Page<CpcCompanyEmployee>*/List<CpcCompanyEmployee> page(Map<String,Object> map){
		try {
			logger.info("CpcCompanyEmployeeService----->page()不执行缓存");
			List<Sort.Order> orders = new ArrayList<>();
			orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
			
			Sort sort = new Sort(orders);
			
			Pageable pageable = new PageRequest(0, 10, sort);
			List<CpcCompanyEmployee> list = (List<CpcCompanyEmployee>) redisClient.get("cn.ld.cpc.redis.service.CpcCompanyEmployeeServicepage{}", List.class);
			logger.info(list);
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
			
			redisClient.delete("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.save");
			
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
		    
		    
		    redisClient.delete("cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis.saveList");
		    
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出错");
		}
	}

}
