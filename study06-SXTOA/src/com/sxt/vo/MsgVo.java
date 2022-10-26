package com.sxt.vo;
/**
 * servlet将json格式的数据相应到前端页面
 * 
 * @author Administrator
 *
 */
public class MsgVo {
	private String code;//状态码
	private String info;//相应数据
	public MsgVo() {
		super();
	}
	public MsgVo(String code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "MsgVo [code=" + code + ", info=" + info + "]";
	}
}
