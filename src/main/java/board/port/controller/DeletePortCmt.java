package board.port.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortCmtVO;

public class DeletePortCmt extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8;");
		
		PortCmtVO vo= new PortCmtVO();
		vo.setPortCmtNo(Integer.parseInt(req.getParameter("port_cmt_no")));
		vo.setPortNo(Integer.parseInt(req.getParameter("port_no")));
		
		PortBoardService service= new PortBoardService();
		service.deletePortCmt(vo);
		
		resp.sendRedirect("getPortDetail?port_no="+vo.getPortNo());
	}
	
}
