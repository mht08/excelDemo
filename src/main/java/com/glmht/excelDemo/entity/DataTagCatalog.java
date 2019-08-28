package com.glmht.excelDemo.entity;

import java.util.Date;

public class DataTagCatalog {
	private Long id; // '编号',
	private String name; // '名称',
	private String number; // '编码',
	private String numberType; // '目类型 1：类型，2正常目录',
	private String parentNumber; // '父级编号',
	private String parentNumbers; // '所有父级编号',
	private Integer sort; // '排序',
	private Integer level; // '级别',
	private String businessTable; // '业务表',
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getParentNumbers() {
		return parentNumbers;
	}

	public void setParentNumbers(String parentNumbers) {
		this.parentNumbers = parentNumbers;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getBusinessTable() {
		return businessTable;
	}

	public void setBusinessTable(String businessTable) {
		this.businessTable = businessTable;
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
