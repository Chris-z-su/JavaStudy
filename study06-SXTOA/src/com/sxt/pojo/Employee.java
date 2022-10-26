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
	/**
	 * 部门信息
	 */
	private Dept dept;
	/**
	 * 岗位信息
	 */
	private Position position;
	/**
	 * 上级信息
	 */
	private Employee mgremp;
	/**
	 * 下级员工List集合
	 */
	private List<Employee> nextemplist;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 性别
	 */
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
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * QQ号
	 */
	private String qq;
	/**
	 * 紧急联系人
	 */
	private String emercontactperson;
	/**
	 * 身份证号
	 */
	private String idcard;
	
	public Employee() {
		super();
	}
	
	/**
	 * 
	 * @param empid
	 * @param dept
	 * @param position
	 * @param mgremp
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param leavedate
	 * @param onduty
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 */
	public Employee(String empid, Dept dept, Position position,
			Employee mgremp, String realname, String sex, Date birthdate,
			Date hiredate, Date leavedate, int onduty, String phone, String qq,
			String emercontactperson, String idcard) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.onduty = onduty;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
	}

	/**
	 * 
	 * @param empid
	 * @param dept
	 * @param mgremp
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param leavedate
	 * @param onduty
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 */
	public Employee(String empid, Dept dept,
			Employee mgremp, String realname, String sex, Date birthdate,
			Date hiredate, Date leavedate, int onduty, String phone, String qq,
			String emercontactperson, String idcard) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.mgremp = mgremp;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.onduty = onduty;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
	}

	/**
	 * @param empid
	 * @param password
	 * @param dept
	 * @param position
	 * @param mgremp
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param onduty
	 * @param emptype
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 */
	public Employee(String empid, String password, Dept dept,
			Position position, Employee mgremp, String realname, String sex,
			Date birthdate, Date hiredate, int onduty, int emptype,
			String phone, String qq, String emercontactperson, String idcard) {
		super();
		this.empid = empid;
		this.password = password;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.onduty = onduty;
		this.emptype = emptype;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
	}
	/**
	 * @param empid
	 * @param dept
	 * @param position
	 * @param mgremp
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param onduty
	 * @param emptype
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 */
	public Employee(String empid, Dept dept, Position position,
			Employee mgremp, String realname, String sex, Date birthdate,
			Date hiredate, int onduty, int emptype,
			String phone, String qq, String emercontactperson, String idcard) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.onduty = onduty;
		this.emptype = emptype;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
	}

	/**
	 * @param empid
	 * @param password
	 * @param dept
	 * @param position
	 * @param mgremp
	 * @param nextemplist
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param leavedate
	 * @param onduty
	 * @param emptype
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 */
	public Employee(String empid, String password, Dept dept,
			Position position, Employee mgremp, List<Employee> nextemplist,
			String realname, String sex, Date birthdate, Date hiredate,
			Date leavedate, int onduty, int emptype, String phone, String qq,
			String emercontactperson, String idcard) {
		super();
		this.empid = empid;
		this.password = password;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
		this.nextemplist = nextemplist;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Employee getMgremp() {
		return mgremp;
	}

	public void setMgremp(Employee mgremp) {
		this.mgremp = mgremp;
	}

	public List<Employee> getNextemplist() {
		return nextemplist;
	}

	public void setNextemplist(List<Employee> nextemplist) {
		this.nextemplist = nextemplist;
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

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", password=" + password
				+ ", dept=" + dept + ", position=" + position + ", mgremp="
				+ mgremp + ", nextemplist=" + nextemplist + ", realname="
				+ realname + ", sex=" + sex + ", birthdate=" + birthdate
				+ ", hriedate=" + hiredate + ", leavedate=" + leavedate
				+ ", onduty=" + onduty + ", emptype=" + emptype + ", phone="
				+ phone + ", qq=" + qq + ", emercontactperson="
				+ emercontactperson + ", idcard=" + idcard + "]";
	}
}
