package com.glmht.excelDemo.entity;

import java.util.Date;

public class DataTagHierarchy {
	private Long id; // '编号',
	private String name; // '名称',
	private Long tagId; // '标签ID',
	private String description; // '描述',
	private String estimatesNumber; // '预估人数',
	private String proportion; // '占比',
	private String usageScenario; // '使用场景',
	private String generativeRule; // '生成规则',
	private String dataSourceName; // '数据库名称',
	private String dataSourceLibrary; // '库名',
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
	public Long getTagId() {
		return tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstimatesNumber() {
		return estimatesNumber;
	}
	public void setEstimatesNumber(String estimatesNumber) {
		this.estimatesNumber = estimatesNumber;
	}
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getUsageScenario() {
		return usageScenario;
	}
	public void setUsageScenario(String usageScenario) {
		this.usageScenario = usageScenario;
	}
	public String getGenerativeRule() {
		return generativeRule;
	}
	public void setGenerativeRule(String generativeRule) {
		this.generativeRule = generativeRule;
	}
	public String getDataSourceName() {
		return dataSourceName;
	}
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
	public String getDataSourceLibrary() {
		return dataSourceLibrary;
	}
	public void setDataSourceLibrary(String dataSourceLibrary) {
		this.dataSourceLibrary = dataSourceLibrary;
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
