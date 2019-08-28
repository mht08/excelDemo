package com.glmht.excelDemo.entity;

import java.util.Date;

import com.glmht.excelDemo.entity.common.BasicEntity;

/**
 * 数据权限表
 * 
 * @author mahaitao
 *
 */
public class DataSignAuth extends BasicEntity {

	private static final long serialVersionUID = 4298746638775249740L;

	private Long id; // '编号',
	private String name; // '权限名称',
	private String create_by; // '创建者',
	private Date create_date; // '创建时间',
	private String update_by; // '更新者',
	private Date update_date; // '更新时间',
	private String version; // '版本号',
	private String del_flag; // '删除标记',
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
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
