package com.glmht.excelDemo.entity;

import java.util.Date;

public class DataTagHierarchyDetail {
	private Long id; // '编号',
	private Long tagHierarchyId; // '标签分层ID',
	private String businessTable; // '表名',
	private String fieldName; // '字段名称',
	private String description; // '描述',
	private Long state; // '字段类型',
	private String option1; // '选择',
	private String value; // '值',
	private String beginTime; // '开始时间',
	private String endTime; // '结束时间',
	private String beginValue; // '开始值',
	private String endValue; // '结束值',
	private String estimatesNumber; // '预估人数',
	private String createBy; // '创建者',
	private Date createDate; // '创建时间',
	private String updateBy; // '更新者',
	private Date updateDate; // '更新时间',
	private String version; // '版本号',
	private String delFlag; // '删除标记',
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTagHierarchyId() {
		return tagHierarchyId;
	}
	public void setTagHierarchyId(Long tagHierarchyId) {
		this.tagHierarchyId = tagHierarchyId;
	}
	public String getBusinessTable() {
		return businessTable;
	}
	public void setBusinessTable(String businessTable) {
		this.businessTable = businessTable;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getBeginValue() {
		return beginValue;
	}
	public void setBeginValue(String beginValue) {
		this.beginValue = beginValue;
	}
	public String getEndValue() {
		return endValue;
	}
	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}
	public String getEstimatesNumber() {
		return estimatesNumber;
	}
	public void setEstimatesNumber(String estimatesNumber) {
		this.estimatesNumber = estimatesNumber;
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
