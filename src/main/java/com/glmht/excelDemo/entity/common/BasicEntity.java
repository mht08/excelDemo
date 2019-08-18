package com.glmht.excelDemo.entity.common;

import java.io.Serializable;
import java.util.Date;

public class BasicEntity implements Serializable {

	private static final long serialVersionUID = 7948120104972436894L;
	
	public static final String DEL_FLAG_NORMAL = "0";// 正常状态
	public static final String DEL_FLAG_CANCEL = "1";// 删除状态
	
	private Long id;//ID
	private String createBy;//创建者ID
	private Date createDate;//创建时间
	private String updateBy;//修改ID
	private Date updateDate;//修改时间
	private String version;//版本号
	private String delFlag;//删除状态
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
