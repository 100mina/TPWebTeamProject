package board.free.model;

import java.net.http.HttpConnectTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
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
				board.setUserId(rs.getString("USER_ID"));
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
			
			String sql="SELECT * FROM FREE_BOARD WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeNo());
			
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				board= new FreeBoardVO();
				board.setFreeNo(rs.getInt("FREE_NO"));
				board.setFreeTitle(rs.getString("FREE_TITLE"));
				board.setFreeContent(rs.getString("FREE_CONTENT"));
				board.setUserId(rs.getString("USER_ID"));
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
			
			String sql = "INSERT INTO FREE_BOARD(FREE_NO, FREE_TITLE, FREE_CONTENT, USER_ID, FREE_CATEGORY) VALUES(SEQ_FREE_NO.NEXTVAL, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, vo.getFreeTitle());
	        pstmt.setString(2, vo.getFreeContent());
	        pstmt.setString(3, vo.getUserId());
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
			
			String sql="UPDATE FREE_BOARD SET FREE_TITLE=?, FREE_CONTENT=?, FREE_CATEGORY=? WHERE FREE_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFreeTitle());
			pstmt.setString(2, vo.getFreeContent());
			pstmt.setString(3, vo.getFreeCategory());
			pstmt.setInt(4, vo.getFreeNo());
			
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
		
	}//...............................................................
	
	//댓글 읽어오기
	public List<FreeCommentVO> getFreeCmtList(FreeCommentVO vo){
		List<FreeCommentVO> freeCmtList= new ArrayList<FreeCommentVO>();
		
		Connection conn;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM FREE_COMMENT WHERE FREE_NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeNo());
			ResultSet rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				FreeCommentVO board= new FreeCommentVO();
				
				board.setFreeCmtNo(rs.getInt("FREE_CMT_NO"));
				board.setFreeNo(rs.getInt("FREE_NO"));
				board.setUserId(rs.getString("USER_ID"));
				board.setFreeCmtContent(rs.getString("FREE_CMT_CONTENT"));
				board.setFreeCmtDate(rs.getTimestamp("FREE_CMT_DATE"));
			   
				freeCmtList.add(board);
				
			} //while 끝
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return freeCmtList;
	
	}//.......................................................
	
	// 댓글 등록 메소드
    public void insertFreeComment(FreeCommentVO vo) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO FREE_COMMENT (FREE_CMT_NO, FREE_NO, USER_ID, FREE_CMT_CONTENT, FREE_CMT_DATE)"
            		+ " VALUES (SEQ_FREE_CMT_NO.NEXTVAL"
            		+ ", ?, ?, ?, SYSDATE)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"FREE_CMT_NO"});
            pstmt.setInt(1, vo.getFreeNo());
            pstmt.setString(2, vo.getUserId());
            pstmt.setString(3, vo.getFreeCmtContent());
            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//......................................................
    
    //댓글 수정
    public void updateFreeComment(FreeCommentVO vo) {
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="UPDATE FREE_COMMENT SET FREE_CMT_CONTENT=?, FREE_CMT_DATE=? WHERE FREE_CMT_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFreeCmtContent());
			pstmt.setTimestamp(2, vo.getFreeCmtDate());
			pstmt.setInt(3, vo.getFreeCmtNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//.............................................................
	
	//댓글 삭제
	public void deleteFreeComment(FreeCommentVO vo) {
		try {
			Connection conn= dataSource.getConnection();
			
			String sql="DELETE FROM FREE_COMMENT WHERE FREE_CMT_NO=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFreeCmtNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//...............................................................
	
	//댓글 수 읽어오기
	public int getCommentCountForBoard(int freeNo) {
	    int commentCount = 0;

	    try {
	        Connection conn = dataSource.getConnection();
	        String sql = "SELECT COUNT(*) FROM FREE_COMMENT WHERE FREE_NO = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, freeNo);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            commentCount = rs.getInt(1);
	        }

	        rs.close();
	        pstmt.close();
	        conn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return commentCount;
	}
	

	
	public List<FreeBoardVO> getFreeBoardListPaging(int pageNo, int pageSize) {
	    List<FreeBoardVO> resultList = new ArrayList<>();

	    try (Connection conn = dataSource.getConnection()) {
	        // 쿼리 작성
	        String query = "SELECT * FROM (SELECT ROWNUM AS rnum, f.* FROM free_board f ORDER BY FREE_NO DESC) WHERE rnum BETWEEN ? AND ?";
	        int startRow = (pageNo - 1) * pageSize + 1;
	        int endRow = pageNo * pageSize;

	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, startRow);
	            pstmt.setInt(2, endRow);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                // 결과 처리
	                while (rs.next()) {
	                    FreeBoardVO board = new FreeBoardVO();
	                    board.setFreeNo(rs.getInt("FREE_NO"));
	                    board.setFreeTitle(rs.getString("FREE_TITLE"));
	                    board.setFreeContent(rs.getString("FREE_CONTENT"));
	    				board.setUserId(rs.getString("USER_ID"));
	    				board.setFreeDate(rs.getDate("FREE_DATE"));
	    				board.setFreeView(rs.getInt("FREE_VIEW"));
	    				board.setFreeCategory(rs.getString("FREE_CATEGORY"));

	                    resultList.add(board);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
	
	//카테고리별로 글 가져오는 기능
	public List<FreeBoardVO> getFreeBoardListByCategory(String category) {
	    List<FreeBoardVO> freeBoardList = new ArrayList<>();

	    try (Connection conn = dataSource.getConnection()) {
	        // 쿼리 작성

	        String query = "SELECT * FROM FREE_BOARD WHERE FREE_CATEGORY = ? ORDER BY FREE_NO DESC";

	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, category);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                // 결과 처리
	                while (rs.next()) {
	                    FreeBoardVO board = new FreeBoardVO();
	                    board.setFreeNo(rs.getInt("FREE_NO"));
	                    board.setFreeTitle(rs.getString("FREE_TITLE"));
	                    board.setFreeContent(rs.getString("FREE_CONTENT"));
	                    board.setUserId(rs.getString("USER_ID"));
	                    board.setFreeDate(rs.getDate("FREE_DATE"));
	                    board.setFreeView(rs.getInt("FREE_VIEW"));
	                    board.setFreeCategory(rs.getString("FREE_CATEGORY"));

	                    freeBoardList.add(board);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    return freeBoardList;
	}
}
