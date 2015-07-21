package cn.sdu.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Filedown entity. @author MyEclipse Persistence Tools
 */

public class Filedown implements java.io.Serializable {

	// Fields

	private Integer fid;
	private User user;
	private Document document;
	private Date downtime;

	// Constructors

	/** default constructor */
	public Filedown() {
	}

	/** minimal constructor */
	public Filedown(Integer fid, Timestamp downtime) {
		this.fid = fid;
		this.downtime = downtime;
	}

	/** full constructor */
	public Filedown(Integer fid, User user, Document document,
			Date downtime) {
		this.fid = fid;
		this.user = user;
		this.document = document;
		this.downtime = downtime;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Date getDowntime() {
		return this.downtime;
	}

	public void setDowntime(Date downtime) {
		this.downtime = downtime;
	}

}