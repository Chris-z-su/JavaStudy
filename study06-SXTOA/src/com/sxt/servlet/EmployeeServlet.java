package com.sxt.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Dept;
import com.sxt.pojo.Employee;
import com.sxt.pojo.Position;
import com.sxt.service.EmpService;
import com.sxt.service.impl.DeptServiceImpl;
import com.sxt.service.impl.EmpServiceImpl;
import com.sxt.service.impl.PositionServiceImpl;
import com.sxt.util.DateToStr;

public class EmployeeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmpService empService = new EmpServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求编码格式
		request.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取前端页面提交的数据
		// 根据method的值的不同，调用不同的处理方法
		String method = request.getParameter("method");
		if ("findemp".equals(method)) {// 查找员工信息method=findemp
			findemp(request, response);
		} else if ("addemp".equals(method)) {// 添加员工信息，先查询数据，method=addemp
			// 查询部门、岗位、上级信息
			addemp(request, response);
		} else if ("insertemp".equals(method)) {// 添加员工信息method=insertemp
			insertemp(request, response);
		}else if("querybyempid".equals(method)){//修改员工信息，先按照员工编号查询数据method=querybyempid
			querybyempid(request, response);
		}else if("updateemp".equals(method)){//修改员工信息method=updateemp
			updateemp(request, response);
		}else if("deleteemp".equals(method)){//删除员工信息method=deleteemp
			deleteemp(request, response);
		}else if("selectbyempid".equals(method)){//查询员工信息method=selectbyempid
			selectbyempid(request, response);
		}else if("argsfindemp".equals(method)){//多条件查询method=argsfindemp
			argsfindemp(request, response);
		}
	}


	/**
	 * 查询所有的员工信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findemp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用service层
		List<Employee> employeeList = empService.selectEmployeeService();
		// 查询部门
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		
		// 将查询到的员工信息放到作用域对象中
		request.setAttribute("employeeList", employeeList);
		request.setAttribute("deptList", deptList);

		// 转发到empList.jsp页面
		request.getRequestDispatcher("/employee/empList.jsp").forward(request,
				response);
	}

	/**
	 * 查询部门、岗位、上级信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void addemp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 访问servlet查询部门、岗位、上级信息
		// 查询部门
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		// 查询岗位
		List<Position> positionList = new PositionServiceImpl().selectPositionService();
		// 查询上级信息
		List<Employee> mgrList = empService.selectMgrList();

		// 将查询的数据存储到request对象中
		request.setAttribute("deptList", deptList);
		request.setAttribute("positionList", positionList);
		request.setAttribute("mgrList", mgrList);

		// 转发到empAdd.jsp页面
		request.getRequestDispatcher("/employee/empAdd.jsp").forward(request,
				response);
	}

	/**
	 * 添加员工信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertemp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的数据
		String empid = request.getParameter("empid");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		
		//出生日期
		Date birthdate = null;
		if(request.getParameter("birthdate") != null && !"".equals(request.getParameter("birthdate"))){
			birthdate = DateToStr.str2Date(request.getParameter("birthdate"));
		}
		
		//入职时间
		Date hiredate = null;
		if(request.getParameter("hiredate") != null && !"".equals(request.getParameter("hiredate"))){
			hiredate = DateToStr.str2Date(request.getParameter("hiredate"));
		}
		
		//离职时间
//		Date leavedate = null;
//		if(request.getParameter("leavedate") != null && !"".equals(request.getParameter("leavedate"))){
//			leavedate = DateToStr.str2Date(request.getParameter("leavedate"));
//		}
		
		//在职状态：0-离职  1-在职
		int onduty = 0;
		if(request.getParameter("onduty") != null){
			onduty = Integer.valueOf(request.getParameter("onduty"));
			
		}

		//员工类型：1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员
		int emptype = 1;
		if(request.getParameter("emptype") != null){
			emptype = Integer.valueOf(request.getParameter("emptype"));
		}
		
		//所属部门
		Dept dept = new Dept();
		if(request.getParameter("deptno") != null){
			dept.setDeptno(Integer.valueOf(request.getParameter("deptno")));
		}
		
		//所属岗位
		Position position = new Position();
		if(request.getParameter("posid") != null){
			position.setPosid(Integer.valueOf(request.getParameter("posid")));
		}
		
		//直接上司
		Employee mgremp = new Employee();
		mgremp.setEmpid(request.getParameter("mgrid"));
		
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String emercontactperson = request.getParameter("emercontactperson");
		String idcard = request.getParameter("idcard");
		
		//创建Employee对象存储所添加的员工信息
		Employee employee = new Employee(empid, dept, position, mgremp, realname, sex, birthdate, hiredate, onduty, emptype, phone, qq, emercontactperson, idcard);
		
		//调用service层
		String url = "";//响应地址
		int num = empService.insertEmployeeService(employee);
		System.out.println(num);
		if(num == 1){
			//添加成功，跳转到empList.jsp
			url = "employeeServlet.bjsxt?method=findemp";
		}else{
			//删除失败，返回到empAdd页面
			//添加错误信息
			request.setAttribute("error", "添加失败！");
			url = "employeeServlet.bjsxt?method=addemp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	/**
	 * 按照编号查询员工信息(用于修改员工信息)
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void querybyempid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取request对象中的员工编号
		String empid = request.getParameter("empid");
		
		//调用service层
		//获取员工信息
		Employee employee = empService.selectQueryByEmpidService(empid);
		
		// 查询部门
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		// 查询岗位
		List<Position> positionList = new PositionServiceImpl().selectPositionService();
		// 查询上级信息
		List<Employee> mgrList = empService.selectMgrList();

		//将查询到的数据添加到作用域对象中
		request.setAttribute("employee", employee);
		request.setAttribute("deptList", deptList);
		request.setAttribute("positionList", positionList);
		request.setAttribute("mgrList", mgrList);
		
		//转发到empUpdate.jsp
		request.getRequestDispatcher("/employee/empUpdate.jsp").forward(request, response);
	}
	
	/**
	 * 修改员工信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateemp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的数据
		String empid = request.getParameter("empid");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		
		//出生日期
		Date birthdate = null;
		if(request.getParameter("birthdate") != null && !"".equals(request.getParameter("birthdate"))){
			birthdate = DateToStr.str2Date(request.getParameter("birthdate"));
		}
		
		//入职时间
		Date hiredate = null;
		if(request.getParameter("hiredate") != null && !"".equals(request.getParameter("hiredate"))){
			hiredate = DateToStr.str2Date(request.getParameter("hiredate"));
		}
		
		//离职时间
		Date leavedate = null;
		if(request.getParameter("leavedate") != null && !"".equals(request.getParameter("leavedate"))){
			leavedate = DateToStr.str2Date(request.getParameter("leavedate"));
		}
		
		//在职状态：0-离职  1-在职
		int onduty = 0;
		if(request.getParameter("onduty") != null){
			onduty = Integer.valueOf(request.getParameter("onduty"));
			
		}
		
		//所属部门
		Dept dept = new Dept();
		if(request.getParameter("deptno") != null){
			dept.setDeptno(Integer.valueOf(request.getParameter("deptno")));
		}
		
		//所属岗位
		Position position = new Position();
		if(request.getParameter("posid") != null){
			position.setPosid(Integer.valueOf(request.getParameter("posid")));
		}
		
		//直接上司
		Employee mgremp = new Employee();
		mgremp.setEmpid(request.getParameter("mgrid"));
		
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String emercontactperson = request.getParameter("emercontactperson");
		String idcard = request.getParameter("idcard");
		
		//创建Employee对象存储所添加的员工信息
		Employee employee = new Employee(empid, dept, position, mgremp, realname, sex, birthdate, hiredate, leavedate, onduty, phone, qq, emercontactperson, idcard);
		
		//调用service层
		String url = "";//响应地址
		int num = empService.updateEmployeeService(employee);

		if(num == 1){
			//修改成功，跳转到empList.jsp
			url = "employeeServlet.bjsxt?method=findemp";
		}else{
			//修改失败，返回到empUpdate.jsp页面
			//添加错误信息
			request.setAttribute("error", "修改失败！");
			url = "employeeServlet.bjsxt?method=querybyempid&empid="+empid;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * 删除员工信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deleteemp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取request对象中的员工编号
		String empid = request.getParameter("empid");
		
		//调用service层
		int num = empService.deleteEmpService(empid);
		if(num > 0){
			//跳转到empList页面
			request.setAttribute("info", "删除成功！");
		}else{
			request.setAttribute("info", "删除失败！");
		}
		request.getRequestDispatcher("employeeServlet.bjsxt?method=findemp").forward(request, response);
	}
	
	/**
	 * 按照编号查询员工信息(用于查看员工基本信息)
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void selectbyempid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//request对象中的员工信息
		String empid = request.getParameter("empid");
		
		//调用service层
		//获取员工信息
		Employee employee = empService.selectQueryByEmpidService(empid);
		
		//查询上级name
		Employee mgremp = empService.selectQueryByEmpidService(employee.getMgremp().getEmpid());
		
		//添加到作用域对象中
		request.setAttribute("employee", employee);
		request.setAttribute("mgremp", mgremp);
		
		//转发到empInfo.jsp页面
		request.getRequestDispatcher("/employee/empInfo.jsp").forward(request, response);
	}
	/**
	 * 多条件查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void argsfindemp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的数据
		String empid = request.getParameter("empid");
		String deptno = request.getParameter("deptno");
		String onduty = request.getParameter("onduty");
		String hiredate = request.getParameter("hiredate");
		
		// 调用service层
		List<Employee> employeeList = empService.selectEmployeeByArgsService(empid, deptno, onduty, hiredate);
		// 查询部门(显示在下拉框中)
		List<Dept> deptList = new DeptServiceImpl().findDeptService();
		
		// 将查询到的员工信息放到作用域对象中
		request.setAttribute("employeeList", employeeList);
		request.setAttribute("deptList", deptList);

		// 转发到empList.jsp页面
		request.getRequestDispatcher("/employee/empList.jsp").forward(request, response);
	}
}
