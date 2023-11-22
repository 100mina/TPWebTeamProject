package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FreeBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 데이터 인코딩, 응답 MIME 타입 및 인코딩
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");	
		
		
		
	}
	
	

}
