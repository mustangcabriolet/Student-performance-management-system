package org.model;

/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */

public class Xsb implements java.io.Serializable {

	// Fields

	private String xh;
	private String xm;
	private Short xb;
	private String cssj;
	//private Integer zyId;
	private Integer zxf;
	private String bz;
	private byte[] zp;//
	private Zyb zyb;//

	// Constructors

	/** default constructor */
	public Xsb() {
	}

	/** minimal constructor */
	public Xsb(String xh, String xm, Short xb) {//
		this.xh = xh;
		this.xm = xm;
		this.xb = xb;
		//this.zyId = zyId;
	}

	/** full constructor */
	public Xsb(String xh, String xm, Short xb, String cssj,//
			Integer zxf, String bz, byte[] zp, Zyb zyb) {//
		this.xh = xh;
		this.xm = xm;
		this.xb = xb;
		this.cssj = cssj;
		//this.zyId = zyId;
		this.zxf = zxf;
		this.bz = bz;
		this.zp = zp;
		this.zyb = zyb;//
	}

	// Property accessors

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Short getXb() {
		return this.xb;
	}

	public void setXb(Short xb) {
		this.xb = xb;
	}

	public String getCssj() {
		return this.cssj;
	}

	public void setCssj(String cssj) {
		this.cssj = cssj;
	}
/*
	public Integer getZyId() {
		return this.zyId;
	}

	public void setZyId(Integer zyId) {
		this.zyId = zyId;
	}
*/
	public Integer getZxf() {
		return this.zxf;
	}

	public void setZxf(Integer zxf) {
		this.zxf = zxf;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public byte[] getZp() {//
		return this.zp;
	}

	public void setZp(byte[] zp) {//
		this.zp = zp;
	}
	//******************
	public Zyb getZyb(){
		return this.zyb;
	}	
	public void setZyb(Zyb zyb){
		this.zyb = zyb;
	}
	//
}