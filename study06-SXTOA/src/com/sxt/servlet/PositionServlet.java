package com.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Position;
import com.sxt.service.PositionService;
import com.sxt.service.impl.PositionServiceImpl;

public class PositionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PositionService positionService = new PositionServiceImpl();
	
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
		
		if("addposition".equals(method)){//添加岗位method=addposition
			addposition(request, response);
		}else if("findposition".equals(method)){//查询岗位method=findposition
			findposition(request, response);
		}else if("querybyposidposition".equals(method)){//按照ID查询数据method=querybyposidposition
			querybyposidposition(request, response);
		}else if("updateposition".equals(method)){//修改岗位信息method=updateposition
			updateposition(request, response);
		}else if("deleteposition".equals(method)){//删除岗位method=deleteposition
			deleteposition(request, response);
		}
	}

	/**
	 * 添加岗位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addposition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的数据
		int posid = Integer.valueOf(request.getParameter("posid"));
		String pname = request.getParameter("pname");
		String pdesc = request.getParameter("pdesc");
		
		Position position = new Position(posid, pname, pdesc);
		
		int num = positionService.insertPositionService(position);
		//判断是否添加成功
		if(num == 0){
			//添加失败返回添加页面
			request.setAttribute("error", "添加失败！");
			request.getRequestDispatcher("/position/positionAdd.jsp").forward(request, response);
		}else{
			System.out.println("OK");
			//跳转到positionList.jsp   
			//positionServlet.bjsxt?method=findposition把数据查询出来
			response.sendRedirect(request.getContextPath()+"/positionServlet.bjsxt?method=findposition");
		}
	}
	/**
	 * 查询全部岗位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findposition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用service层
		List<Position> positionList = positionService.selectPositionService();
		
		//将List集合放到作用域对象中
		request.setAttribute("positionList", positionList);
		request.getRequestDispatcher("/position/positionList.jsp").forward(request, response);
	}
	/**
	 * 按照编号查询数据
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void querybyposidposition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取request对象中的posid值
		int posid = Integer.valueOf(request.getParameter("posid"));
		
		//调用service层
		Position position = positionService.selectPositionByPosidService(posid);
		
		//将数据存放到作用域对象中
		request.setAttribute("position", position);
		
		//转发到修改页面
		request.getRequestDispatcher("/position/positionUpdate.jsp").forward(request, response);
	}
	/**
	 * 修改岗位信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updateposition(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//获取表单提交的数据
		int posid = Integer.valueOf(request.getParameter("posid"));
		String pname = request.getParameter("pname");
		String pdesc = request.getParameter("pdesc");
		
		Position position = new Position(posid, pname, pdesc);
		//调用service层
		int num = positionService.updatePositionService(position);
		
		if(num > 0){
			//修改成功，跳转到positionList.html
			response.sendRedirect(request.getContextPath()+"/positionServlet.bjsxt?method=findposition");
		}else{
			//修改失败，跳回修改页面
			request.setAttribute("error", "修改失败！");
			request.getRequestDispatcher("/position/positionUpdate.jsp").forward(request, response);
		}
	}
	/**
	 * 删除岗位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deleteposition(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//获取request对象中的posid值
		int posid = Integer.valueOf(request.getParameter("posid"));
		
		//调用service层
		int num = positionService.deletePositionService(posid);
		
		if(num >0 ){
			request.setAttribute("info", "删除成功");
		}else{
			request.setAttribute("info", "删除失败");
		}
		//跳转到positionList.jsp页面
		request.getRequestDispatcher("/positionServlet.bjsxt?method=findposition").forward(request, response);
	}
}
