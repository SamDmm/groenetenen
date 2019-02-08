package be.vdab.groenetenen.web;

import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

public class VanTotPostcodeForm {
	@NotNull
	@Range(min = 1000, max = 9999)
	private Integer van;
	@NotNull
	@Range(min = 1000, max = 9999)
	private Integer tot;
	
	public Integer getVan() {
		return van;
	}
	public void setVan(Integer van) {
		this.van = van;
	}
	public Integer getTot() {
		return tot;
	}
	public void setTot(Integer tot) {
		this.tot = tot;
	}
}
