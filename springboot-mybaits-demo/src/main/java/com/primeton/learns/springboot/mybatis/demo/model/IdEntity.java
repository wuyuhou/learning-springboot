package com.primeton.learns.springboot.mybatis.demo.model;

/**
 * IdEntity
 * 
 * @author wuyuhou
 *
 */
public class IdEntity implements java.io.Serializable {

	private static final long serialVersionUID = -5194578595566629481L;

	// ID名称
	private String idName;

	// ID值
	private long idValue;
	
	//当前ID值
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
