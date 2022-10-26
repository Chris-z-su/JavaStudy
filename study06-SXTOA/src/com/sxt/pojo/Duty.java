package com.sxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Duty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int dtid;
	/**
	 * 员工用户名
	 */
	private String emprid;
	/**
	 * 签到签退的日期
	 */
	private Date dtdate;
	/**
	 * 签到时间
	 */
	private String signintime;
	/**
	 * 签退时间
	 */
	private String signouttime;
	public Duty() {
		super();
	}
	/**
	 * @param dtid
	 * @param emprid
	 * @param dtdate
	 * @param signintime
	 * @param signouttime
	 */
	public Duty(int dtid, String emprid, Date dtdate, String signintime,
			String signouttime) {
		super();
		this.dtid = dtid;
		this.emprid = emprid;
		this.dtdate = dtdate;
		this.signintime = signintime;
		this.signouttime = signouttime;
	}
	public int getDtid() {
		return dtid;
	}
	public void setDtid(int dtid) {
		this.dtid = dtid;
	}
	public String getEmprid() {
		return emprid;
	}
	public void setEmprid(String emprid) {
		this.emprid = emprid;
	}
	public Date getDtdate() {
		return dtdate;
	}
	public void setDtdate(Date dtdate) {
		this.dtdate = dtdate;
	}
	public String getSignintime() {
		return signintime;
	}
	public void setSignintime(String signintime) {
		this.signintime = signintime;
	}
	public String getSignouttime() {
		return signouttime;
	}
	public void setSignouttime(String signouttime) {
		this.signouttime = signouttime;
	}
	@Override
	public String toString() {
		return "Duty [dtid=" + dtid + ", emprid=" + emprid + ", dtdate="
				+ dtdate + ", signintime=" + signintime + ", signouttime="
				+ signouttime + "]";
	}
}
