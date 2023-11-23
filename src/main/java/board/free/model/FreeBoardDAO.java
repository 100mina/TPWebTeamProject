package board.free.model;

import java.net.http.HttpConnectTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FreeBoardDAO {
	
	DataSource dataSource;
	
	public FreeBoardDAO() {
		try {
			Context context= new InitialContext();
			Context envContext= (Context) context.lookup("java:/comp/env");
			dataSource= (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println("오라클 DBMS의 커넥션풀이 완성되었습니다.");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//.............................................................................
	
	// 게시물 전체 얻어오기
	public List<FreeBoardVO> getFreeBoardList(){
		List<FreeBoardVO> freeBoardList= new ArrayList<FreeBoardVO>();
		
		Connection conn;
		try {
			conn = dataSource.getConnection();
			String sql="SELECT * FROM FREE_BOARD ORDER BY FREE_NO DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				FreeBoardVO board= new FreeBoardVO();
				board.setFreeNo(rs.getInt("FREE_NO"));
				board.setFreeTitle(rs.getString("FREE_TITLE"));
				board.setFreeContent(rs.getString("FREE_CONTENT"));
				board.setUserNickname(rs.getString("USER_NICKNAME"));
				board.setFreeDate(rs.getDate("FREE_DATE"));
				board.setFreeView(rs.getInt("FREE_VIEW"));
				board.setFreeCategory(rs.getString("FREE_CATEGORY"));
				
				freeBoardList.add(board);
				
			} //while 끝
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return freeBoardList;
	
	}//.......................................................
	
	// 상세 글 검색 기능
	public FreeBoardVO getFreeBoard(FreeBoardVO vo) {
		FreeBoardVO board= null;
		
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="SELECT * FROW FREE_BOARD WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeNo());
			
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				board= new FreeBoardVO();
				board.setFreeNo(rs.getInt("FREE_NO"));
				board.setFreeTitle(rs.getString("FREE_TITLE"));
				board.setFreeContent(rs.getString("FREE_CONTENT"));
				board.setUserNickname(rs.getString("USER_NICKNAME"));
				board.setFreeDate(rs.getDate("FREE_DATE"));
				board.setFreeView(rs.getInt("FREE_VIEW"));
				board.setFreeCategory(rs.getString("FREE_CATEGORY"));			
			}
			
			rs.close();
			pstmt.close();
			conn.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}//...........................................................................
	
	//조회수 증가 기능
	public void increaseView(FreeBoardVO vo) {
		
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="UPDATE FREE_BOARD SET FREE_VIEW=(SELECT FREE_VIEW FROM FREE_BOARD WHERE FREE_NO=?)+1 WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeNo());
			pstmt.setInt(2, vo.getFreeNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//.........................................................................
	
	// 게시글 추가 [ 새글 or 답글 ]
	public void insertFreeBoard(FreeBoardVO vo) {
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="INSERT INTO FREE_BOARD(FREE_NO,FREE_TITLE,FREE_CONTENT,USER_NICKNAME,FREE_CATEGORY) VALUES(SEQ_FREE_BNO.NEXTVAL,?,?,?,?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFreeTitle());
			pstmt.setString(2, vo.getFreeContent());
			pstmt.setString(3, vo.getUserNickname());
			pstmt.setString(4, vo.getFreeCategory());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//.................................................................
	
	//게시글 수정
	public void updateFreeBoard(FreeBoardVO vo) {
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="UPDATE FREE_BOARD SET FREE_TITLE=?, FREE_CONTENT=? WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFreeTitle());
			pstmt.setString(2, vo.getFreeContent());
			pstmt.setInt(3, vo.getFreeNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//.............................................................
	
	//게시글 삭제
	public void deleteFreeBoard(FreeBoardVO vo) {
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="DELETE FROM FREE_BOARD WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
