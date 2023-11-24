package board.port.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.port.model.PortBoardImgVO;
import board.port.model.PortBoardService;

public class GetImg extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//요청 파라미터 받기 - 파일 번호
		String imgNo= req.getParameter("img_no");
		PortBoardImgVO vo= new PortBoardImgVO();
		vo.setImgNo(Integer.parseInt(imgNo));
		
		PortBoardService service= new PortBoardService();
		PortBoardImgVO img= service.getImg(vo);
		
		resp.setContentType("image/*");
		
		//파일과 연결된 입력 스트림 준비
		FileInputStream fis= new FileInputStream(img.getImgPath());
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


