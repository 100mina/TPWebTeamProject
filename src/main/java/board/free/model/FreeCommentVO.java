package board.free.model;

import java.sql.Date;
import java.sql.Timestamp;

public class FreeCommentVO {
	
	private int freeCmtNo;           //댓글번호
	private int freeNo;              //댓글달린 게시글 번호
	private String userId;	 //댓글단 유저 닉네임
	private String userNickname;
	
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String freeCmtContent;   //댓글내용
	private Timestamp freeCmtDate;      //댓글작성일자
	
	public int getFreeCmtNo() {
		return freeCmtNo;
	}
	public void setFreeCmtNo(int freeCmtNo) {
		this.freeCmtNo = freeCmtNo;
	}
	public int getFreeNo() {
		return freeNo;
	}
	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}
	
	public String getFreeCmtContent() {
		return freeCmtContent;
	}
	public void setFreeCmtContent(String freeCmtContent) {
		this.freeCmtContent = freeCmtContent;
	}
	public Timestamp getFreeCmtDate() {
		
		return freeCmtDate;
	}
	public void setFreeCmtDate(Timestamp parsedDate) {
		this.freeCmtDate = parsedDate;
	}
	
	
	
	
}
