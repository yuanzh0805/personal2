package cn.sdu.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typename;
	private Integer extendid;
	private Set documents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String typename) {
		this.typename = typename;
	}

	/** full constructor */
	public Type(String typename, Integer extendid, Set documents) {
		this.typename = typename;
		this.extendid = extendid;
		this.documents = documents;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getExtendid() {
		return this.extendid;
	}

	public void setExtendid(Integer extendid) {
		this.extendid = extendid;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

}