package board.free.model;

import java.sql.Date;
import java.util.List;

public class FreeBoardVO {
	
	private int freeNo;            //게시글 번호
	private String freeTitle;      //제목
	private String freeContent;    //내용
	private String userId;   //작성자 닉네임
	private Date freeDate;         //작성일
	private int freeView;          //조회수
	private String freeCategory;       //카테고리
	private int commentCount;

    // getter 및 setter 추가
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
	//getter & setter
	
	public int getFreeNo() {
		return freeNo;
	}
	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getFreeDate() {
		return freeDate;
	}
	public void setFreeDate(Date freeDate) {
		this.freeDate = freeDate;
	}
	public int getFreeView() {
		return freeView;
	}
	public void setFreeView(int freeView) {
		this.freeView = freeView;
	}
	public String getFreeCategory() {
		return freeCategory;
	}
	public void setFreeCategory(String freecategory) {
		freeCategory = freecategory;
	}

	
}
