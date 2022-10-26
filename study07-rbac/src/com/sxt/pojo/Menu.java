package com.sxt.pojo;

import java.util.List;

public class Menu {
	private int mid;//存储菜单ID
	private String mname;//存储菜单名
	private String murl;//菜单URL
	private String mdesc;//菜单描述
	private int pid;//菜单父ID
	private List<Menu> lm;//存储二级菜单信息
	
	public Menu() {
		super();
	}

	public Menu(int mid, String mname, String murl, String mdesc, int pid,
			List<Menu> lm) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
		this.mdesc = mdesc;
		this.pid = pid;
		this.lm = lm;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Menu> getLm() {
		return lm;
	}

	public void setLm(List<Menu> lm) {
		this.lm = lm;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", murl=" + murl
				+ ", mdesc=" + mdesc + ", pid=" + pid + ", lm=" + lm + "]";
	}
}
