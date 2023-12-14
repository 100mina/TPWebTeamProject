package board.port.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.port.model.PortBoardImgVO;
import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;

@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*10)
public class UpdatePortBoard extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String portTitle= req.getParameter("port_title");
		String portContent= req.getParameter("port_content");
		int portNo= Integer.parseInt(req.getParameter("port_no"));
		
		
		PortBoardVO vo= new PortBoardVO();
		vo.setPortTitle(portTitle);
		vo.setPortContent(portContent);
		vo.setPortNo(portNo);
		
		//멀티파트 파일 데이터 받기(첨부파일)
		Collection<Part> parts= req.getParts();

		File path= new File("C:/Users/user1/Desktop/img/WebTeamProjectImg");
		
		// 부모 폴더가 존재하지 않으면 생성
		//if (!path.getParentFile().isDirectory()) path.getParentFile().mkdirs();
		// 현재 폴더가 존재하지 않으면 생성
		if (!path.isDirectory()) path.mkdirs();
		
		PortBoardService service = new PortBoardService();
		List<PortBoardImgVO> imgList = new ArrayList<PortBoardImgVO>();

		for (Part part : parts) {
		    String contentType = part.getContentType();

		    if (contentType != null && contentType.startsWith("image/")) { // 이미지인 경우에만 실행
		        String fileName = part.getSubmittedFileName();
		        String dstName = path + "/" + System.currentTimeMillis() + fileName;
		        
		        // 파일을 실제로 디스크에 저장
		        part.write(dstName);

		        // VO 객체로 만들기
		        PortBoardImgVO imgvo = new PortBoardImgVO();
		        imgvo.setImgPath(dstName);
		        imgvo.setPortNo(portNo);

		        imgList.add(imgvo);
		    }
		}//for..

		if (imgList.size() != 0) {
		    service.updatePortBoard(vo, imgList);
		} else {
		    service.updatePortBoard(vo);
		}

		// 화면구현 작업 - 변경된 게시물 상세화면
		resp.sendRedirect("getPortDetail?port_no=" + vo.getPortNo());

	}
		
}
