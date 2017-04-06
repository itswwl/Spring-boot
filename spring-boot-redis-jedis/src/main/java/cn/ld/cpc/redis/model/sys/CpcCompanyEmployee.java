package cn.ld.cpc.redis.model.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CPC_COMPANY_EMPLOYEE")
public class CpcCompanyEmployee {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="gen_cpc_organization_seq" )
    @SequenceGenerator(name="gen_cpc_organization_seq",allocationSize=1,initialValue=1, sequenceName="cpc_organization_seq")
	private Long id;
	@Column(name="realname")
	private String realName;//名称
	@Column(name="idcardno")
	private String idCardNo;//身份证号码
	@Column(name="rspersonalid")
	private Long rsPersonalID;//关联的个人ID:为0，则没有关联
	@Column(name="currentorgid")
	private Long currentORGID;//最后一级的部门ID
	@Column(name="createuserid")
	private Long createUserID;
	@Column(name="createtime")
	private Date createTime;
	@Column(name="lastupdatetime")
	private Date lastUpdateTime;
	@Column(name="createusertype")
	private String createUserType;
	@Column(name="removeuserid")
	private Long removeUserId;
	@Column(name="removetime")
	private Date removeTime;
	@Column(name="removeusertype")
	private String removeUserType;
	@Column(name="rsorguserid")
	private Long rsOrgUserId;
	@Column(name="pinyin")
	private String pinyin;
	@Column(name="status")
	private Integer status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Long getRsPersonalID() {
		return rsPersonalID;
	}
	public void setRsPersonalID(Long rsPersonalID) {
		this.rsPersonalID = rsPersonalID;
	}
	public Long getCurrentORGID() {
		return currentORGID;
	}
	public void setCurrentORGID(Long currentORGID) {
		this.currentORGID = currentORGID;
	}
	public Long getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(Long createUserID) {
		this.createUserID = createUserID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCreateUserType() {
		return createUserType;
	}
	public void setCreateUserType(String createUserType) {
		this.createUserType = createUserType;
	}
	public Long getRemoveUserId() {
		return removeUserId;
	}
	public void setRemoveUserId(Long removeUserId) {
		this.removeUserId = removeUserId;
	}
	public Date getRemoveTime() {
		return removeTime;
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public String getRemoveUserType() {
		return removeUserType;
	}
	public void setRemoveUserType(String removeUserType) {
		this.removeUserType = removeUserType;
	}
	
	public Long getRsOrgUserId() {
		return rsOrgUserId;
	}
	public void setRsOrgUserId(Long rsOrgUserId) {
		this.rsOrgUserId = rsOrgUserId;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CpcCompanyEmployee [id=" + id + ", realName=" + realName + ", idCardNo=" + idCardNo + ", rsPersonalID="
				+ rsPersonalID + ", currentORGID=" + currentORGID + ", createUserID=" + createUserID + ", createTime="
				+ createTime + ", lastUpdateTime=" + lastUpdateTime + ", createUserType=" + createUserType
				+ ", removeUserId=" + removeUserId + ", removeTime=" + removeTime + ", removeUserType=" + removeUserType
				+ ", rsOrgUserId=" + rsOrgUserId + ", pinyin=" + pinyin + ", status=" + status + "]";
	}
	
	
}
