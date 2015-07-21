package cn.sdu.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String userpwd;
	private Integer usernum;
	private Set documents = new HashSet(0);
	private Set filedowns = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String userpwd) {
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.usernum = usernum;
	}

	/** full constructor */
	public User(Integer userid, String username, String userpwd,
			Integer usernum, Set documents, Set filedowns, Set comments) {
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.usernum = usernum;
		this.documents = documents;
		this.filedowns = filedowns;
		this.comments = comments;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Integer getUsernum() {
		return this.usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getFiledowns() {
		return this.filedowns;
	}

	public void setFiledowns(Set filedowns) {
		this.filedowns = filedowns;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}