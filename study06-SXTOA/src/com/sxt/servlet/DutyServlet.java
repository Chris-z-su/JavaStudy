package com.sxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sxt.pojo.Dept;
import com.sxt.pojo.Duty;
import com.sxt.pojo.Employee;
import com.sxt.service.DutyService;
import com.sxt.service.impl.DeptServiceImpl;
import com.sxt.service.impl.DutyServiceImpl;
import com.sxt.util.DateToStr;
import com.sxt.util.PageUtil;
import com.sxt.vo.DutyEmpVo;
import com.sxt.vo.MsgVo;

public class DutyServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 查询签到记录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findsign(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//获取session对象中存储的员工信息
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		
		//调用service层
		DutyService dutyService = new DutyServiceImpl();
		
		//查询签到记录
		Duty duty = dutyService.selectDutyService(emp.getEmpid());
		
		
		//将json格式的数据返回到前端页面 
		/*
		 * MsgVo:vo值对象
		 * 		作用：servlet将json格式的数据相应到前端页面
				属性：
					code 1 已签到 ；0 未签到 ；  
					info ' 已签到'  或 '未签到
		 * 
		 */
		MsgVo msgVo = null;
		if(duty != null){
			//已签到
			msgVo = new MsgVo("1", "已签到");
		}else{
			//未签到
			msgVo = new MsgVo("0", "未签到");
		}
		
		Gson gson = new Gson();
		String rsJson = gson.toJson(msgVo);
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.println(rsJson);
	}
	/**
	 * 签到
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void signin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//获取session对象中存储的员工信息
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		//获取当前日期
		String dtdate = DateToStr.date2Str(new Date());
		//获取当前时间
		String signintime = DateToStr.dateTime2Str(new Date());
		
		//调用service层
		DutyService dutyService = new DutyServiceImpl();
		//签到
		int num = dutyService.signInService(emp.getEmpid(), dtdate, signintime);
		MsgVo msgVo = null;
		if(num == 1){
			msgVo = new MsgVo("1", "签到成功！");
		}else{
			msgVo = new MsgVo("0", "签到失败！");
		}
		
		Gson gson = new Gson();
		String rsJson = gson.toJson(msgVo);
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.println(rsJson);
	}
	
	/**
	 * 签退
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void signout(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//获取session对象中存储的员工信息
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		//获取当前日期
		String dtdate = DateToStr.date2Str(new Date());
		//获取当前时间
		String signouttime = DateToStr.dateTime2Str(new Date());
		
		//调用service层
		DutyService dutyService = new DutyServiceImpl();
		//签退
		int num = dutyService.signOutService(emp.getEmpid(), dtdate, signouttime);
		MsgVo msgVo = null;
		if(num == 1){
			msgVo = new MsgVo("1", "签退成功！");
		}else{
			msgVo = new MsgVo("0", "签退失败！");
		}
		
		Gson gson = new Gson();
		String rsJson = gson.toJson(msgVo);
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.println(rsJson);
	}
	
	/**
	 * 查询签到记录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void queryallsign(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//获取前端页面数据
		String currnavStr = request.getParameter("currnav");
		
		int pagesize = 10 ;//一页显示10 行
		int currnav = 1; //当前页
		int navnum = 10 ; //页面的导航栏维护的导航数
		
		if(currnavStr != null ){
			currnav = Integer.valueOf(currnavStr);
		}
		
		/**
		 * 从数据库查询出来,查询数据总行数
		 */
		//调用service层
		DutyService dutyService = new DutyServiceImpl();
		int rowcount =  dutyService.selectSignCountService();
		
		// 查询部门
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		
		//将分页数据拼装好，传到前端页面
		//调用pageUtil工具  ，获取分页导航栏数据
		PageUtil<?> pageUtil = new PageUtil<>(rowcount, pagesize, currnav, navnum);
		
		int startRow = pageUtil.getStartrow();
		
		//查询签到记录
		List<DutyEmpVo> dutyEmpList = dutyService.queryAllSignService(startRow, pagesize);
		
		request.setAttribute("pageUtil", pageUtil);
		request.setAttribute("dutyEmpList", dutyEmpList);
		request.setAttribute("deptList", deptList);
		
		//转发
		request.getRequestDispatcher("/duty/dutyList.jsp").forward(request, response);
	}
	
	/**
	 * 多条件分页查询签到记录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void queryallsignargs(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//获取前端页面数据
		String currnavStr = request.getParameter("currnav");
		String empid = request.getParameter("empid");
		String deptno = request.getParameter("deptno");
		String dtdate = request.getParameter("dtdate");
		
//		System.out.println(empid+deptno+dtdate);
		
		int pagesize = 10 ;//一页显示10 行
		int currnav = 1; //当前页
		int navnum = 10 ; //页面的导航栏维护的导航数
		
		if(currnavStr != null ){
			currnav = Integer.valueOf(currnavStr);
		}
		
		/**
		 * 从数据库查询出来,查询数据总行数
		 */
		//调用service层
		DutyService dutyService = new DutyServiceImpl();
		int rowcount =  dutyService.selectSignCountService();
		
		// 查询部门
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		
		//将分页数据拼装好，传到前端页面
		//调用pageUtil工具  ，获取分页导航栏数据
		PageUtil<?> pageUtil = new PageUtil<>(rowcount, pagesize, currnav, navnum);
		
		int startRow = pageUtil.getStartrow();
		
		//查询签到记录
		List<DutyEmpVo> dutyEmpList = dutyService.queryAllSignArgsService(startRow, pagesize, empid, deptno, dtdate);
		
		request.setAttribute("pageUtil", pageUtil);
		request.setAttribute("dutyEmpList", dutyEmpList);
		request.setAttribute("deptList", deptList);
		
		//转发
		request.getRequestDispatcher("/duty/dutyList.jsp").forward(request, response);
	}
}
