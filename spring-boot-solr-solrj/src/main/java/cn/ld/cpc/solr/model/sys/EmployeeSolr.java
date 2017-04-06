package cn.ld.cpc.solr.model.sys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import org.apache.solr.client.solrj.beans.Field;

//@Entity
public class EmployeeSolr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Field
	//@org.springframework.data.annotation.Id 
	private String id;
	
	@Field
	private String realname;
	
	@Field
	private String idcardno;
	
	@Field
	private Date createtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdcardno() {
		return idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}
