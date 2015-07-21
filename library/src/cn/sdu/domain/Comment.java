package cn.sdu.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer cid;
	private User user;
	private Document document;
	private String content;
	private Date comtime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(String content, Timestamp comtime) {
		this.content = content;
		this.comtime = comtime;
	}

	/** full constructor */
	public Comment(User user, Document document, String content,
			Timestamp comtime) {
		this.user = user;
		this.document = document;
		this.content = content;
		this.comtime = comtime;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getComtime() {
		return this.comtime;
	}

	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}

}