package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.free.model.FreeBoardService;
import board.free.model.FreeCommentVO;

@WebServlet("/deleteFreeCmt")
public class FreeCmtDeleteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("댓글 삭제를 요청하셨습니다.");
		
		String freeCmtNo= req.getParameter("free_cmt_no");
		FreeBoardService freeBoardService= new FreeBoardService(); //모델 작업 대행사 객체

		
		FreeCommentVO vo = new FreeCommentVO();
		vo.setFreeCmtNo(Integer.parseInt(freeCmtNo));
		
		List<FreeCommentVO> freeCmtList= freeBoardService.deleteFreeCmt(vo);
		
		HttpSession session= req.getSession();
		session.setAttribute("freeCmtList", freeCmtList);
        resp.getWriter().write("Success"); // 댓글 삭제 성공 시 "Success" 응답
	}
	

}
