package board.free.model;

import java.util.List;

public class FreeBoardService {
	
	//서블릿과 DAO의 중간 대행사 역할 수행
	
		FreeBoardDAO freeBoardDao;
		
		public FreeBoardService() {
			freeBoardDao= new FreeBoardDAO();
		}//............................................
		
		
		//서블릿이 요청할 기능 메소드들...
		
		//#1. 전체 게시글 검색기능
		public List<FreeBoardVO> getFreeBoardList(){
			return freeBoardDao.getFreeBoardList();
		}
		
		//#2. 게시글 상세 검색기능 - [ 게시글 검색 쿼리와 조회수 증가 쿼리를 실행해야 함 ]
		public FreeBoardVO getFreeBoard(FreeBoardVO vo) {
			FreeBoardVO board= freeBoardDao.getFreeBoard(vo); //#1) 게시글 검색 쿼리
			freeBoardDao.increaseView(vo);  //#2) 조회수 증가 쿼리

			return board;
		}
		
		//#3. 게시글 저장 기능 -- 서블릿에게 새로 추가된 게시글을 포함한 새로운 게시글 리스트를 리턴해 줌
		public List<FreeBoardVO> insertFreeBoard(FreeBoardVO vo) {
			freeBoardDao.insertFreeBoard(vo); //게시글 저장		
			return freeBoardDao.getFreeBoardList();
		}
		
		//#4. 게시글 수정 기능
		public FreeBoardVO updateBoard(FreeBoardVO vo) {
			freeBoardDao.updateFreeBoard(vo);
			return freeBoardDao.getFreeBoard(vo);  //게시글 수정 후 상세글 페이지로 다시 이동하여 그 결과를 보기 위해.. 리턴
		}
		
		//#5. 게시글 삭제 기능
		public List<FreeBoardVO> deleteBoard(FreeBoardVO vo){
			freeBoardDao.deleteFreeBoard(vo);
			return freeBoardDao.getFreeBoardList(); //삭제된 후 전체 게시글 리턴..
		}
		
}
