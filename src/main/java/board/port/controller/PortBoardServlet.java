package board.port.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.port.model.PortBoardDAO;
import board.port.model.PortBoardImgVO;
import board.port.model.PortBoardService;
import board.port.model.PortBoardVO;
import user.model.UserDAO;
import user.model.UserVO;
@WebServlet("/portBoardList")
public class PortBoardServlet extends HttpServlet{
	private static final Date Date = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	
	void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		
		PortBoardService portBoardService = new PortBoardService();
		PortBoardDAO portBoardDAO = new PortBoardDAO();
		UserDAO userDAO = new UserDAO();
		List<PortBoardVO> portBoardList = portBoardService.getPortList();
		for(int i=0;i<portBoardList.size();i++) {
			UserVO userVO = new UserVO();
			userVO.setId(portBoardList.get(i).getUserId());
			List<PortBoardImgVO> imgVOs= portBoardDAO.getPortImgs(portBoardList.get(i));
			PortBoardImgVO imgVO = portBoardDAO.getImg(imgVOs.get(0));
			// 썸네일 이미지 no 전달
			portBoardList.get(i).setThumbnailImageNo(imgVO.getImgNo());
			portBoardList.get(i).setCountFav(portBoardDAO.countFav(portBoardList.get(i)));
			
		}
		
		Gson gson = new Gson();
		String toJson = gson.toJson(portBoardList);
		
	    resp.getWriter().write(toJson);
	}

}
