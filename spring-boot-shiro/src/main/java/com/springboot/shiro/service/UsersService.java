package com.springboot.shiro.service;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.shiro.dao.RoleSourceDao;
import com.springboot.shiro.dao.RolesDao;
import com.springboot.shiro.dao.SourceDao;
import com.springboot.shiro.dao.UserRoleDao;
import com.springboot.shiro.dao.UsersDao;
import com.springboot.shiro.entry.RoleSource;
import com.springboot.shiro.entry.Roles;
import com.springboot.shiro.entry.Sources;
import com.springboot.shiro.entry.UserRole;
import com.springboot.shiro.entry.Users;
import com.springboot.shiro.pojo.SessionUser;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired 
	private RolesDao rolesDao;
	
	@Autowired
	private RoleSourceDao roleSourceDao;
	
	@Autowired
	private SourceDao sourceDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Transactional(readOnly = true)
	public Users findOne(Long id){
		return usersDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public /*Users*/SessionUser login(String uname,String pwd){
		Users users = usersDao.findByUP(uname, pwd);
		return getSessionUser(users);
		//return usersDao.findByUP(uname, pwd);
	}
	
//	private Map<String,?> findAuthority(Long uid){
//		Map<String,Object> map = new HashMap<String, Object>();
//		return map;
//	}
	
	/**
	 * @param users
	 * @return
	 * 
	 * 组装用户对象
	 * 
	 */
	private SessionUser getSessionUser(Users users){
		if(users==null){
			return null;
		}
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUser(users);
		//获得登陆用户角色
		Set<UserRole> userRole = userRoleDao.findRoleByUID(users.getId());
		
		final Set<Long> roleids = new HashSet<Long>();
		if(userRole!=null){
			userRole.stream().forEach((item)->{
				roleids.add(item.getRoleid());
			});
		}
		
		Set<Roles> roles = null;
		if(roleids.size()>0){
			roles = rolesDao.findByIDS(roleids);
		}
		sessionUser.setRoles(roles);
		
		//获得登陆用户权限
		Set<RoleSource> roleSources = null;
		if(roleids.size()>0){
			roleSources = roleSourceDao.findSourceByRoleIDs(roleids);
		}
		
		
		final Set<Long> sourceids = new HashSet<>();
		if(roleSources!=null){
			roleSources.stream().forEach((item)->{
				sourceids.add(item.getSourceid());
			});
		}
		
		Set<Sources> sources = null;
		if(sourceids.size()>0){
			sources = sourceDao.findBySourceIDS(sourceids);
		}
		
		sessionUser.setSources(sources);
		
		//获得权限url和权限标记
		final Set<String> urls = new HashSet<>();
		final Set<String> authority = new HashSet<>();
		final Set<Long> sourcesids = new HashSet<>();
//		//左侧菜单
//		Map<String, Set<Map<String, Object>>> leftmenu = new HashMap<>();
		
		if(sources!=null){
			sources.stream().forEach((item)->{
				String url = item.getUrl();
				String permission = item.getPermission();
				Integer type = item.getType();
				if(StringUtils.isNotBlank(url)){
					urls.add(url);
				}
				if(StringUtils.isNotBlank(permission)){
					authority.add(permission);
				}
				sourcesids.add(item.getId());
			});
		}
		sessionUser.setUrls(urls);
		sessionUser.setAuthority(authority);
		sessionUser.setSourcesids(sourcesids);
		
		return sessionUser;
	}

}
