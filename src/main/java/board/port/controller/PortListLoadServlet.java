package board.port.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;


@WebServlet("/loadPortList")
public class PortListLoadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		
		PortBoardVO portBoardVO = new PortBoardVO();
		PortBoardService pbService = new PortBoardService();
		List<PortBoardVO> portList = pbService.getPortList();
		
		
		
		
		
		
	}
}
