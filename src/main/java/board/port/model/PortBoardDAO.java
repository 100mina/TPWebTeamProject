package board.port.model;

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

public class PortBoardDAO {
	
	DataSource dataSource;
	
	public PortBoardDAO() {
		try {
			Context context=new InitialContext();
			Context envContext= (Context)context.lookup("java:/comp/env");
			dataSource=(DataSource)envContext.lookup("jdbc/oracle");
			System.out.println("오라클 DBMS의 커넥션풀이 완성되었습니다. 언제든지 Connection을 꺼내 사용");
			//커넥션 디비랑 연결하는 애
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//생성자
	//전체조회//
	public List<PortBoardVO> selectAllBoard(){
		List<PortBoardVO> portBoardList =new ArrayList<PortBoardVO>();
	
		
	
		try {
			Connection conn = dataSource.getConnection();
			String sql= "SELECT * FROM PORT_BOARD";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PortBoardVO portBoard= new PortBoardVO();
				portBoard.setPortNo(rs.getInt("PORT_NO"));
				portBoard.setPortTitle(rs.getString("PORT_TITLE"));
				portBoard.setPortContent(rs.getString("PORT_CONTENT"));
				portBoard.setUserId(rs.getString("USER_ID"));
				portBoard.setPortDate(rs.getDate("PROT_DATE"));
				portBoard.setPortView(rs.getInt("PORT_VIEW"));
				portBoard.setImgPath(rs.getString("IMG_PATH"));
				portBoard.setPortFavNo(rs.getInt("PORT_FAV_NO"));
				
				portBoardList.add(portBoard);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return portBoardList;
	}
	
	//이미지 경로 조회  //수정해야 할 수도 있음.
	public PortBoardVO selectImagePath(PortBoardVO vo) {
		
		PortBoardVO imagePath=null;
		
		
		
		try {
			Connection conn=dataSource.getConnection();
			String sql="SELECT IMG_PATH FROM PORT_BOARD_IMG WHERE PORT_NO=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, vo.getPortNo());
				ResultSet rs=pstmt.executeQuery();

				if(rs.next()) {
					imagePath=new PortBoardVO();
					imagePath.setImgPath(rs.getString("IMG_PATH"));
					
					}
				rs.close();
				pstmt.close();
				conn.close();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imagePath;
	}
	
	//사용자 아이디 가져오기
	public PortBoardVO selectUserId(PortBoardVO vo){
		
		PortBoardVO board=null;
		
		
		try {
			Connection conn=dataSource.getConnection();
			String sql="SELECT USER_ID FROM PORT_BOARD WHERE PORT_NO=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPortNo());
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				board=new PortBoardVO();
				board.setUserId(rs.getString("USER_ID"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	//사용자 프로필 이미지 조회// 테이블 아직 안함
	public String selectUserProfileImage(String userId) {
		
		String profileImagePath=null;
		String sql="SELECT PROFILE_IMAGE_PATH FROM USER_PROFILE WHERE USER_ID=?";
		
		try {
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			try(ResultSet rs=pstmt.executeQuery()){
				
				if(rs.next()) {
					profileImagePath=rs.getString("PROFILE_IMAGE_PATH");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return profileImagePath;
		
	}
	
	//조회수 증가//
	public void increaseViewCount(PortBoardVO vo) {
		
		
		try {
			Connection conn=dataSource.getConnection();
			String sql="UPDATE PORT_BOARD SET PORT_VIEW= (SELECT PORT_VIEW FROM PORT_BOARD WHERE PORT_NO=?)+1 WHERE PORT_NO=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getPortNo());
			pstmt.setInt(2, vo.getPortNo());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//좋아요 수 조회
	public int selectLikeCount(int portNo) {
		
		int likeCount=0;
		String sql="SELECT COUNT(*) AS LIKE_COUNT FROM PORT_FAVORITE WHERE PORT_NO=?";
		
		try {
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, portNo);
			
			try(ResultSet rs=pstmt.executeQuery()){
				if(rs.next()) {
					likeCount=rs.getInt("LIKE_COUNT");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return likeCount;
		
		
	}

}
