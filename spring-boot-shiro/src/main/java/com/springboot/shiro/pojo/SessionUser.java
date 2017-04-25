package com.springboot.shiro.pojo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.springboot.shiro.entry.Roles;
import com.springboot.shiro.entry.Sources;
import com.springboot.shiro.entry.Users;

public class SessionUser {
	
	private Users user;
	private Set<Roles> roles;
	private Set<Sources> sources;
	private Set<String> urls;
	private Set<String> authority;
	private Map<Long,Set<Sources>> leftmenu = new HashMap<>();
	private Set<Long> sourcesids ;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		if(roles!=null){
			this.roles = Collections.unmodifiableSet(roles);
		}else{
			this.roles = Collections.emptySet();
		}
	}
	public Set<Sources> getSources() {
		return sources;
	}
	public void setSources(Set<Sources> sources) {
		if(sources!=null){
			this.sources = Collections.unmodifiableSet(sources);
		}else{
			this.sources = Collections.emptySet();
		}
	}
	public Set<String> getUrls() {
		return urls;
	}
	public void setUrls(Set<String> urls) {
		if(urls!=null){
			this.urls = Collections.unmodifiableSet(urls);
		}else{
			this.urls = Collections.emptySet();
		}
		
	}
	public Set<String> getAuthority() {
		return authority;
	}
	public void setAuthority(Set<String> authority) {
		if(authority!=null){
			this.authority = Collections.unmodifiableSet(authority);
		}else{
			this.authority = Collections.emptySet();
		}
	}

	public Map<Long, Set<Sources>> getLeftmenu() {
		return leftmenu;
	}
//	public void setLeftmenu(Map<Long, Set<Sources>> leftmenu) {
//		if(leftmenu!=null){
//			this.leftmenu = Collections.unmodifiableMap(leftmenu);
//		}else{
//			this.leftmenu = Collections.emptyMap();
//		}
//	}
	public Set<Sources> addLeftMenu(Long id,Set<Sources> sources){
		Set<Sources> s = this.leftmenu.get(id);
		if(s!=null){
			s.addAll(sources);
		}
		return this.leftmenu.put(id, sources);
	}
	public Set<Long> getSourcesids() {
		return sourcesids;
	}
	public void setSourcesids(Set<Long> sourcesids) {
		if(sourcesids!=null){
			this.sourcesids = Collections.unmodifiableSet(sourcesids);
		}else{
			this.sourcesids = Collections.emptySet();
		}
	}
	
	
}
