package cn.sdu.domain;

/**
 * Biaoqian entity. @author MyEclipse Persistence Tools
 */

public class Biaoqian implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String bname;

	// Constructors

	/** default constructor */
	public Biaoqian() {
	}

	/** full constructor */
	public Biaoqian(String bname) {
		this.bname = bname;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

}