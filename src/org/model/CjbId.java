package org.model;

/**
 * CjbId entity. @author MyEclipse Persistence Tools
 */

public class CjbId implements java.io.Serializable {

	// Fields

	private String xh;
	private String kch;

	// Constructors

	/** default constructor */
	public CjbId() {
	}

	/** full constructor */
	public CjbId(String xh, String kch) {
		this.xh = xh;
		this.kch = kch;
	}

	// Property accessors

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getKch() {
		return this.kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CjbId))
			return false;
		CjbId castOther = (CjbId) other;

		return ((this.getXh() == castOther.getXh()) || (this.getXh() != null
				&& castOther.getXh() != null && this.getXh().equals(
				castOther.getXh())))
				&& ((this.getKch() == castOther.getKch()) || (this.getKch() != null
						&& castOther.getKch() != null && this.getKch().equals(
						castOther.getKch())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getXh() == null ? 0 : this.getXh().hashCode());
		result = 37 * result
				+ (getKch() == null ? 0 : this.getKch().hashCode());
		return result;
	}

}