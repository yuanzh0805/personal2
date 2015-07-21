package cn.sdu.domain;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminid;
	private String adminname;
	private String adminpwd;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(Integer adminid, String adminname, String adminpwd) {
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
	}

	// Property accessors

	public Integer getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return this.adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

}