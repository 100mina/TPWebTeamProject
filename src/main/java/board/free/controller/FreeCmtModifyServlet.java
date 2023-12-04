package board.free.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.free.model.FreeBoardService;
import board.free.model.FreeCommentVO;
import oracle.sql.DATE;

@WebServlet("/modifyFreeCmt")
public class FreeCmtModifyServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		System.out.println("댓글 수정 기능을 요청하셨습니다.");
		
		String freeCmtNo= req.getParameter("free_cmt_no");
		String freeCmtContent= req.getParameter("free_cmt_content");
		String freeCmtDate= req.getParameter("free_cmt_date");

		FreeCommentVO vo= new FreeCommentVO();
		vo.setFreeCmtNo(Integer.parseInt(freeCmtNo));
		vo.setFreeCmtContent(freeCmtContent);

		DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
		Instant instant = Instant.from(formatter.parse(freeCmtDate));
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		
		vo.setFreeCmtDate(timestamp);
		
		FreeBoardService freeBoardService= new FreeBoardService();
		FreeCommentVO updatedFreeCmt = freeBoardService.updateFreeCmt(vo);

		// 화면 구현
		HttpSession session= req.getSession();
		session.setAttribute("updatedFreeCmt", updatedFreeCmt ); //갱신된 게시글을 세션에 저장		
        resp.getWriter().write("Success"); // 댓글 삭제 성공 시 "Success" 응답

	}
	
}
