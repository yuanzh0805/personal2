package cn.sdu.domain;

/**
 * Like entity. @author MyEclipse Persistence Tools
 */

public class Like implements java.io.Serializable {

	// Fields

	private Integer likeid;
	private User user;
	private Document document;

	// Constructors

	/** default constructor */
	public Like() {
	}

	/** full constructor */
	public Like(User user, Document document) {
		this.user = user;
		this.document = document;
	}

	// Property accessors

	public Integer getLikeid() {
		return this.likeid;
	}

	public void setLikeid(Integer likeid) {
		this.likeid = likeid;
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

}