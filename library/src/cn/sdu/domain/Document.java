package cn.sdu.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */

public class Document implements java.io.Serializable {

	// Fields

	private Integer did;
	private Type type;
	private User user;
	private Integer dnum;
	private String oldname;
	private String newname;
	private String swfname;
	private Date dtime;
	private String label;
	private Integer looknum;
	private Set biaodocs = new HashSet(0);
	private Set likes = new HashSet(0);
	private Set filedowns = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** full constructor */
	public Document(Type type, User user, Integer dnum, String oldname,
			String newname, String swfname, Date dtime, String label,
			Integer looknum, Set biaodocs, Set likes, Set filedowns,
			Set comments) {
		this.type = type;
		this.user = user;
		this.dnum = dnum;
		this.oldname = oldname;
		this.newname = newname;
		this.swfname = swfname;
		this.dtime = dtime;
		this.label = label;
		this.looknum = looknum;
		this.biaodocs = biaodocs;
		this.likes = likes;
		this.filedowns = filedowns;
		this.comments = comments;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getDnum() {
		return this.dnum;
	}

	public void setDnum(Integer dnum) {
		this.dnum = dnum;
	}

	public String getOldname() {
		return this.oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public String getNewname() {
		return this.newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getSwfname() {
		return this.swfname;
	}

	public void setSwfname(String swfname) {
		this.swfname = swfname;
	}

	public Date getDtime() {
		return this.dtime;
	}

	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getLooknum() {
		return this.looknum;
	}

	public void setLooknum(Integer looknum) {
		this.looknum = looknum;
	}

	public Set getBiaodocs() {
		return this.biaodocs;
	}

	public void setBiaodocs(Set biaodocs) {
		this.biaodocs = biaodocs;
	}

	public Set getLikes() {
		return this.likes;
	}

	public void setLikes(Set likes) {
		this.likes = likes;
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