package board.port.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;

public class PortIsLike extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		System.out.println(req.getParameter("user_id")+"/"+req.getParameter("port_no")+"/"+req.getParameter("is_like"));
		
		PortBoardVO vo= new PortBoardVO();
		vo.setUserId(req.getParameter("user_id"));
		vo.setPortNo(Integer.parseInt(req.getParameter("port_no")));
		vo.setIsLike(Boolean.parseBoolean(req.getParameter("is_like")));
		
		PortBoardService service= new PortBoardService();
		service.isLike(vo);
		
		System.out.println("좋아요");
		
	}

}
