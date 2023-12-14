package board.port.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;

public class DeletePortBoard extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int portNo= Integer.parseInt(req.getParameter("port_no"));
		
		PortBoardVO vo= new PortBoardVO();
		vo.setPortNo(portNo);
		
		PortBoardService service= new PortBoardService();
		service.deletePortBoard(vo);
		
		//TODO: 게시판 목록으로 돌아가기..
		resp.sendRedirect("./board/port/portlist.jsp");
		
	}

}
