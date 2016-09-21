package com.yzxd.framework.ssh.web.entity;

import java.util.Date;

public class MUserVip {

	private String id;
	private String userId;
	private String loginName;
	private String password;
	private String personName;
	private String description;
	private String isValid;
	private String delFlag;
	private String updateId;
	private Date updateDate;
	private String createId;
	private Date createDate;
	private String validateCode;
	private Date validateDate;

	public MUserVip() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "MUserVip [id=" + id + ", userId=" + userId + ", loginName=" + loginName + ", password=" + password
				+ ", personName=" + personName + ", description=" + description + ", isValid=" + isValid + ", delFlag="
				+ delFlag + ", updateId=" + updateId + ", updateDate=" + updateDate + ", createId=" + createId
				+ ", createDate=" + createDate + ", validateCode=" + validateCode + ", validateDate=" + validateDate
				+ "]";
	}

}
