package board.free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/insertFreeBoard")
public class FreeBoardInsertServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String freeTitle= req.getParameter("free_title");
		String freeContent= req.getParameter("free_content");
		
		HttpSession session= req.getSession();
		
	}

}
