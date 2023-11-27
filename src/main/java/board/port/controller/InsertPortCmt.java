package board.port.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardService;
import board.port.model.PortCmtVO;

public class InsertPortCmt extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String content= req.getParameter("port_cmt_content");
		int portNo= Integer.parseInt(req.getParameter("port_no"));
		
		//TODO: 회원 정보 VO 사용해서 회원아이디 전달.. 없어서 일단 임의로 데이터 넣음.
		String nickname= "SAM";
		
		PortCmtVO vo= new PortCmtVO();
		vo.setPortNo(portNo);
		vo.setUserId(nickname);
		vo.setPortCmtContent(content);
		
		//비지니스로직
		PortBoardService service= new PortBoardService();
		service.insertPortCmt(vo);
		
		//TODO: 화면구현.. -> 새 댓글이 업데이트 된 현재 상세화면
		resp.sendRedirect("getPortDetail?port_no="+vo.getPortNo());
		
	}

}
