package com.primeton.learns.springboot.jpa.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * IdEntity
 * 
 * @author wuyuhou
 *
 */
@Entity(name = "DEMO_ID_TABLE")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class IdEntity implements java.io.Serializable {

	private static final long serialVersionUID = -5194578595566629481L;

	// ID名称
	@Id
	@Column
	private String idName;

	// ID值
	@Column
	private long idValue;
	
	//当前ID值
	@Transient
	private long currentId;

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public long getIdValue() {
		return idValue;
	}

	public void setIdValue(long idValue) {
		this.idValue = idValue;
	}

	public long getCurrentId() {
		return currentId;
	}

	public void setCurrentId(long currentId) {
		this.currentId = currentId;
	}
}
