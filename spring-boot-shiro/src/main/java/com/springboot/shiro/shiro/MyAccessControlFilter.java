package com.springboot.shiro.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyAccessControlFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		Subject currentUser = SecurityUtils.getSubject();
		// 修改
		// 判断是否登陆
		if (currentUser.isAuthenticated()) {
			try {
				String quanxian = getpByUrl(url);// 根据url去用这则获取权限值
				boolean flag = currentUser.isPermitted(quanxian);
				if (flag) {
					return flag;
				} else {
					WebUtils.issueRedirect(request, response, "/main/index");
					return false;
				}
			} catch (Exception e) {
				WebUtils.issueRedirect(request, response, "/main/index");
				return false;
			}
		} else {
			WebUtils.issueRedirect(request, response, "/user/login");
			return false;
		}

	}

	/**
	 * 根据url去用正则表达式得出url对应的权限值
	 * 
	 * @param url
	 * @return
	 */
	public String getpByUrl(String url) {

		String[] shuzu = url.split("/");
		String menu = shuzu[1];// positionTemp的值
		String pm = shuzu[2];// showadd的值
		if (pm.toLowerCase().contains("add")) {
			return menu + ":" + "add";
		} else if (pm.toLowerCase().contains("update")) {
			return menu + ":" + "update";
		} else if (pm.toLowerCase().contains("view")) {
			return menu + ":" + "view";
		} else if (pm.toLowerCase().contains("delete")) {
			return menu + ":" + "delete";
		}
		return "";
	}

}
