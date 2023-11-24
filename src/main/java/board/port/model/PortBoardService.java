package board.port.model;

import java.util.List;


public class PortBoardService {

	PortBoardDAO dao;
	
	public PortBoardService() {
		dao= new PortBoardDAO();
	}
	
	//게시물 저장
	public List<PortBoardVO> insertPortBoard(PortBoardVO vo) {
		dao.insertPort(vo);
		
		return dao.getPortList();
	}
	
	//첨부파일들 저장
	public void insertPortImg(List<PortBoardImgVO> imgList) {
		dao.insertPortImg(imgList);		
	}
	
	//전체 게시물 검색
	public List<PortBoardVO> getPortList() {
		return dao.getPortList();
	}
	
	//상세 게시물 검색 
	public PortBoardVO getPort(PortBoardVO vo) {
		PortBoardVO port= dao.getPort(vo);
		
		//첨부파일 검색 쿼리
		List<PortBoardImgVO> imgList= dao.getPortImgs(vo);
		port.setPortImgList(imgList);
		
		return port;
	}
	
	//이미지 1개 불러오기
	public PortBoardImgVO getImg(PortBoardImgVO vo) {
		return dao.getImg(vo);
	}
	
	//특정 회원의 게시물 목록 가져오기
	public List<PortBoardVO> getUserPort(PortBoardVO vo) {
		return dao.getUserPort(vo);	
	}
	
}
