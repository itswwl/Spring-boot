package com.springboot.services.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.IItemDetailsDao;
import com.springboot.domain.ItemDetails;
import com.springboot.services.IItemDetailsServices;
import com.springboot.vo.ItemDetailsVO;

@Service
public class ItemDetailsServicesImpl implements IItemDetailsServices {
	
	private static Logger logger = Logger.getLogger(ItemDetailsServicesImpl.class);

	@Autowired
	private IItemDetailsDao itemDetailsDao;
	
	@Transactional
	public List<ItemDetails> findAll() {
		return (List<ItemDetails>)itemDetailsDao.findAll();
	}

	@Transactional
	public Page<ItemDetails> findAll(Pageable pageable) {
		return itemDetailsDao.findAll(pageable);
	}

	@Transactional
	public Page<ItemDetails> getPageById(Integer id, Pageable pageable) {
		return itemDetailsDao.getPageById(id, pageable);
	}
	
	/* 
	 * 
	 * 带有条件的分页查询
	 * 
	 * (non-Javadoc)
	 * @see com.springboot.services.IItemDetailsServices#getPageById(com.springboot.domain.ItemDetails, org.springframework.data.domain.Pageable)
	 * 
	 */
	@Transactional
	public Page<ItemDetails> getPageById(final ItemDetailsVO itemDetailsVO, Pageable pageable){
		
		return itemDetailsDao.findAll(new Specification<ItemDetails>() {

			public Predicate toPredicate(Root<ItemDetails> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				
				Predicate predicate = criteriaBuilder.conjunction();
				//predicate.getExpressions().add(criteriaBuilder.)
				
				if(itemDetailsVO != null){
					logger.info("======================================================="+root.get("goods").<String>get("goodsName"));
					
					if(itemDetailsVO.getGoodsName()!=null){
						predicate.getExpressions().add(criteriaBuilder.like(root.get("goods").<String>get("goodsName"), "%"+itemDetailsVO.getGoodsName()+"%"));
					}
					if(itemDetailsVO.getNum()!=null){
						predicate.getExpressions().add(criteriaBuilder.gt(root.<Number>get("num"), itemDetailsVO.getNum()));
					}
				}
				
				return predicate;
			}
		}, pageable);
	}

}
