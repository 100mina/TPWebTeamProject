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

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardImgVO;
import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;

@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*10)
public class InsertPortBoard extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String portTitle= req.getParameter("port_title");
		String portContent= req.getParameter("port_content");
		String userId= req.getParameter("user_id");
		
		
		PortBoardVO vo= new PortBoardVO();
		vo.setPortTitle(portTitle);
		vo.setPortContent(portContent);
		vo.setUserId(userId);
		
		PortBoardService service= new PortBoardService();
		List<PortBoardVO> boardList= service.insertPortBoard(vo);
		
		
		//멀티파트 파일 데이터 받기(첨부파일)
		Collection<Part> parts= req.getParts();

		File path= new File("D:/WebTeamProjectImg");
		
		// 부모 폴더가 존재하지 않으면 생성
		//if (!path.getParentFile().isDirectory()) path.getParentFile().mkdirs();
		// 현재 폴더가 존재하지 않으면 생성
		if (!path.isDirectory()) path.mkdirs();
		
		
		List<PortBoardImgVO> imgList= new ArrayList<PortBoardImgVO>();
		for(Part part : parts) {
			
			String fileName= part.getSubmittedFileName();
			if(fileName==null) continue;
			
			String dstName= path+"/"+ System.currentTimeMillis()+fileName;
			
			//파일을 실제로 디스크에 저장
			part.write(dstName);
			
			// VO 객체로 만들기
			PortBoardImgVO imgvo= new PortBoardImgVO();
			imgvo.setImgPath(dstName);
			imgvo.setPortNo(boardList.get(0).getPortNo());
			
			imgList.add(imgvo);
			
		}//for..
		
		service.insertPortImg(imgList);
		
		System.out.println(portTitle+":"+portContent+"/"+vo.getUserId()+" 완료 "+boardList.get(0).getPortNo());
		
		//화면구현 작업 - 업로드한 게시물의 상세 화면
		resp.sendRedirect("getPortDetail?port_no=" + boardList.get(0).getPortNo());
	}
	
}
