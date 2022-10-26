package com.sxt.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Administrator
 *
 */
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String empid;
	/**
	 * 密码
	 */
	private String password;
	private String realname;
	private String sex;
	/**
	 * 出生日期
	 */
	private Date birthdate;
	/**
	 * 入职时间
	 */
	private Date hiredate;
	/**
	 * 离职时间
	 */
	private Date leavedate;
	/**
	 * 是否在职
	 * 		0-离职  1-在职
	 */
	private int onduty;
	/**
	 * 员工角色
	 * 		1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员
	 */
	private int emptype;
	private String phone;
	private String qq;
	private String emercontactperson;//紧急联系人
	private String idcard;//身份证号
	public int rid;//角色
	
	public Employee() {
		super();
	}

	public Employee(String empid, String password, String realname, String sex,
			Date birthdate, Date hiredate, Date leavedate, int onduty,
			int emptype, String phone, String qq, String emercontactperson,
			String idcard, int rid) {
		super();
		this.empid = empid;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.onduty = onduty;
		this.emptype = emptype;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
		this.rid = rid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Date getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}

	public int getOnduty() {
		return onduty;
	}

	public void setOnduty(int onduty) {
		this.onduty = onduty;
	}

	public int getEmptype() {
		return emptype;
	}

	public void setEmptype(int emptype) {
		this.emptype = emptype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmercontactperson() {
		return emercontactperson;
	}

	public void setEmercontactperson(String emercontactperson) {
		this.emercontactperson = emercontactperson;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", password=" + password
				+ ", realname=" + realname + ", sex=" + sex + ", birthdate="
				+ birthdate + ", hiredate=" + hiredate + ", leavedate="
				+ leavedate + ", onduty=" + onduty + ", emptype=" + emptype
				+ ", phone=" + phone + ", qq=" + qq + ", emercontactperson="
				+ emercontactperson + ", idcard=" + idcard + ", rid=" + rid
				+ "]";
	}

}
