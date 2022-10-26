package com.sxt.vo;

import java.io.Serializable;
import java.util.Date;

public class DutyEmpVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empid;
	private String realname;
	private String deptname;
	private Date dtdate;
	private String signintime;
	private String signouttime;
	public DutyEmpVo() {
		super();
	}
	public DutyEmpVo(String empid, String realname, String deptname,
			Date dtdate, String signintime, String signouttime) {
		super();
		this.empid = empid;
		this.realname = realname;
		this.deptname = deptname;
		this.dtdate = dtdate;
		this.signintime = signintime;
		this.signouttime = signouttime;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
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
		return "DutyEmpVo [empid=" + empid + ", realname=" + realname
				+ ", deptname=" + deptname + ", dtdate=" + dtdate
				+ ", signintime=" + signintime + ", signouttime=" + signouttime
				+ "]";
	}
}
