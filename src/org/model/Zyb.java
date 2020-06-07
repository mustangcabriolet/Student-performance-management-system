package org.model;

/**
 * Zyb entity. @author MyEclipse Persistence Tools
 */

public class Zyb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String zym;
	private Integer rs;
	private String fdy;

	// Constructors

	/** default constructor */
	public Zyb() {
	}

	/** minimal constructor */
	public Zyb(String zym) {
		this.zym = zym;
	}

	/** full constructor */
	public Zyb(String zym, Integer rs, String fdy) {
		this.zym = zym;
		this.rs = rs;
		this.fdy = fdy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZym() {
		return this.zym;
	}

	public void setZym(String zym) {
		this.zym = zym;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public String getFdy() {
		return this.fdy;
	}

	public void setFdy(String fdy) {
		this.fdy = fdy;
	}

}