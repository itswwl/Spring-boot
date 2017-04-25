package com.springboot.shiro.jdbc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcDaoMySQLImpl implements JdbcDao {
	private static final Logger log = LoggerFactory.getLogger(JdbcDaoMySQLImpl.class);
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public JdbcDaoMySQLImpl()
	    {

	    }

	   public Map<String, Object> queryForOne(String sql, Object... args) {
	        return jdbcTemplate.queryForMap(sql, args);
	    }

	    public List<Map<String, Object>> queryForList(String sql, Object... args) {
	        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
	        return list;
	    }

	    public List<Map<String, Object>> queryForPageList(Pageable pageable, String sql, Object... args) {

	        return this.queryForPageList(pageable.getPageNumber(), pageable.getPageSize(), sql, args);
	    }

	    /**
	     * 获取指定页的数据
	     * @param pageNum 表示当前页码,从0开始为第1页
	     * @param pageSize
	     * @param sql
	     * @param args
	     * @return
	     */
	    public List<Map<String, Object>> queryForPageList(int pageNum, int pageSize, String sql, Object... args) {

	        Long rowStart = Long.valueOf(pageSize * pageNum);
	        Long rowEnd = Long.valueOf(pageSize * (pageNum + 1));



	        if (rowStart <= 0)
	            rowStart = 0L;

	        String pageSql;
	        pageSql = "SELECT * FROM (" +
	                "SELECT t2.*,rownum as rn FROM " +
	                "(" + sql + ") t2 " +
	                "WHERE rownum <= " + rowEnd +
	                ") t3 WHERE t3.rn > " + rowStart;

	        log.debug("pagesql:" + pageSql);
	        return queryForList(pageSql, args);

	    }

	    public Long queryForCount(String sql, Object... args) {
	        log.debug("countsql:" + sql);
	        Map<String, Object> map = jdbcTemplate.queryForMap(sql, args);

	        Collection<Object> co = map.values();
	        Iterator<Object> iterator = co.iterator();
	        if (iterator.hasNext())
	            return Long.parseLong(iterator.next().toString());
	        return 0L;
	    }

	    public Page<Map<String, Object>> queryForPage(int pageNum, int pageSize, String fieldList, String tableList, String queryCondition, String queryOrder, Object... args){

	        Pageable pageable = new PageRequest(pageNum, pageSize);
	        
	        return queryForPage(pageable, fieldList, tableList, queryCondition, queryOrder, args);
	    }

	    public Page<Map<String, Object>> queryForPage(Pageable pageable, String fieldList, String tableList, String queryCondition, String queryOrder, Object... args) {

	        Long totalRecords = this.queryForCount("SELECT COUNT(*) AS CT FROM " + tableList + " " + queryCondition, args);
	        log.debug("totalRecords:" + totalRecords);
	        Page<Map<String, Object>> page = null;

	        List<Map<String, Object>> list = this.queryForPageList(pageable, "SELECT " + fieldList + " FROM " + tableList + " " +  queryCondition  + " " + queryOrder, args);
	        
	        page = new PageImpl<Map<String, Object>>(list, pageable, totalRecords);


	        return page;
	    }

	
}
