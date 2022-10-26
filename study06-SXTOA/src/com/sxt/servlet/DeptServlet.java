package com.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Dept;
import com.sxt.service.DeptService;
import com.sxt.service.impl.DeptServiceImpl;

public class DeptServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeptService deptService = new DeptServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取前端页面提交的数据
		//根据method的值的不同，调用不同的处理方法
		String method = request.getParameter("method");
		if("adddept".equals(method)){
			adddept(request, response);//方法名和method的值保持一致
		}else if("finddept".equals(method)){//部门查询method=finddept
			finddept(request, response);
		}else if("deletedept".equals(method)){//部门删除method=deletedept
			deletedept(request, response);
		}else if("updatequerydept".equals(method)){//部门修改：修改之前先将数据查询出来method=updatequerydept
			updatequerydept(request, response);
		}else if("updatesave".equals(method)){//部门修改method=updatesave
			updatesave(request, response);
		}
	}

	/**
	 * 添加部门
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void adddept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取前端提交的表单数据
		String deptno = request.getParameter("deptno");
		String deptname = request.getParameter("deptname");
		String location = request.getParameter("location");
		
		//调用service
		Dept dept = new Dept();
		dept.setDeptno(Integer.valueOf(deptno));
		dept.setDeptname(deptname);
		dept.setLocation(location);
		
		int num = deptService.addDeptService(dept);
		//判断是否添加成功
		if(num == 0){
			request.setAttribute("error", "添加失败！");
			request.getRequestDispatcher("/dept/deptAdd.jsp").forward(request, response);
		}else{
			System.out.println("OK");
			//跳转到deptlist.html   
			//deptServlet.bjsxt?method=finddept把数据查询出来
			response.sendRedirect(request.getContextPath()+"/deptServlet.bjsxt?method=finddept");
		}
	}
	/**
	 * 查询所有部门
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void finddept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用service层
		List<Dept> deptList = deptService.findDeptService();
		
		//将List集合放到作用域对象中
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/dept/deptList.jsp").forward(request, response);
	}
	/**
	 * 删除部门
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deletedept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取request对象中的deptno值
		int deptno = Integer.valueOf(request.getParameter("deptno"));
		
		//调用service层
		int num = deptService.deleteDeptService(deptno);
		if(num > 0){
			//跳转到deptList页面
			request.setAttribute("info", "删除成功！");
		}else{
			request.setAttribute("info", "删除失败！");
		}
		
		request.getRequestDispatcher("deptServlet.bjsxt?method=finddept").forward(request, response);
	}
	/**
	 * 修改前把原来数据查询出来,显示到deptUpdate.jsp页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatequerydept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取request对象中的deptno值
		int deptno = Integer.valueOf(request.getParameter("deptno"));
		
		//调用service层
		Dept dept = deptService.updateQueryByDeptnoService(deptno);
		
		//将数据放到作用域对象中
		request.setAttribute("dept", dept);
		
		//转发到修改页面：deptUpdate.jsp
		request.getRequestDispatcher("/dept/deptUpdate.jsp").forward(request, response);
	}
	/**
	 * 修改部门
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatesave(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//获取表单提交的数据
		int deptno = Integer.valueOf(request.getParameter("deptno"));
		String deptname = request.getParameter("deptname");
		String location = request.getParameter("location");
		
		Dept dept = new Dept(deptno, deptname, location);
		//调用service层
		int num = deptService.updateDeptService(dept);
		
		if(num > 0){
			//修改成功，跳转到deptlist.html
			response.sendRedirect(request.getContextPath()+"/deptServlet.bjsxt?method=finddept");
		}else{
			//修改失败，跳回修改页面
			request.setAttribute("error", "修改失败！");
			request.getRequestDispatcher("/dept/deptUpdate.jsp").forward(request, response);
		}
	}
}
