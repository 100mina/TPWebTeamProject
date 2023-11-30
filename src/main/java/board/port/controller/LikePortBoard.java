package board.port.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;

public class LikePortBoard extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId = req.getParameter("user_id");
		int portNo = Integer.parseInt(req.getParameter("port_no"));
	    System.out.println("userId: " + userId); 
	    System.out.println("portNo: " + portNo); 

	    PortBoardVO vo= new PortBoardVO();
	    vo.setUserId(userId);
	    vo.setPortNo(portNo);
	    
	    PortBoardService service= new PortBoardService();
	    service.likeOn(vo);
	}

}
