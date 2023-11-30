package board.port.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardVO;
@WebServlet("/portBoardList")
public class PortBoardServlet extends HttpServlet{
	private static final Date Date = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doHandle(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		doHandle(req,resp);
	}
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String portNo=req.getParameter("port_no");
		String portTitle=req.getParameter("port_title");
		String portContent=req.getParameter("port_content");
		String userId=req.getParameter("user_id");
		String portDate=req.getParameter("port_date");
		String portView=req.getParameter("port_view");
		String imgPath=req.getParameter("img_path");
		
		PortBoardVO vo=new PortBoardVO();
		vo.setPortTitle(portTitle);
		vo.setUserId(userId);
	
	}

}
