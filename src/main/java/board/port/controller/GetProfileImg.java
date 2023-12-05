package board.port.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardImgVO;
import board.port.model.PortBoardService;
import user.model.UserVO;

@WebServlet("/getProfileImg")
public class GetProfileImg extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String userId= req.getParameter("user_id");
		
		UserVO vo= new UserVO();
		vo.setId(userId);
		
		PortBoardDAO dao= new PortBoardDAO();
		UserVO user= dao.getUser(vo);
		
		resp.setContentType("image/*");
		
		//파일과 연결된 입력 스트림 준비
		FileInputStream fis= new FileInputStream(user.getProfilePath());
		//브라우저에 응답하기 위한 출력 스트림 준비
		ServletOutputStream sos= resp.getOutputStream();
		
		byte[] buffer= new byte[1024]; //1KB씩 전송
		while(true) {
			int length= fis.read(buffer);
			if(length == -1) break;
			
			sos.write(buffer, 0, length);
		}
		
		
		fis.close();
		sos.close();
		
	}

}
