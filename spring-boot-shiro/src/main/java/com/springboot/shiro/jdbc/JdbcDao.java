package com.springboot.shiro.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcDao {

    public Map<String, Object> queryForOne(String sql, Object... args);

    public List<Map<String, Object>> queryForList(String sql, Object... args);

    public List<Map<String, Object>> queryForPageList(Pageable pageable, String sql, Object... args);

    public List<Map<String, Object>> queryForPageList(int pageNum, int pageSize, String sql, Object... args);

    public Long queryForCount(String sql, Object... args);

    public Page<Map<String, Object>> queryForPage(int pageNum, int pageSize, String fieldList, String tableList, String queryCondition, String queryOrder, Object... args);

    public Page<Map<String, Object>> queryForPage(Pageable pageable, String fieldList, String tableList, String queryCondition, String queryOrder, Object... args);

}
