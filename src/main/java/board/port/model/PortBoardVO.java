package board.port.model;

import java.sql.Date;

public class PortBoardVO {
	
	private int portNo;
	private String portTitle;
	private String portContent;
	private String userId;
	private Date portDate;
	private int portView;
	
	private String imgPath;
	
	public int getPortNo() {
		return portNo;
	}

	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}

	public String getPortTitle() {
		return portTitle;
	}

	public void setPortTitle(String portTitle) {
		this.portTitle = portTitle;
	}

	public String getPortContent() {
		return portContent;
	}

	public void setPortContent(String portContent) {
		this.portContent = portContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPortDate() {
		return portDate;
	}

	public void setPortDate(Date portDate) {
		this.portDate = portDate;
	}

	public int getPortView() {
		return portView;
	}

	public void setPortView(int portView) {
		this.portView = portView;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getPortFavNo() {
		return portFavNo;
	}

	public void setPortFavNo(int portFavNo) {
		this.portFavNo = portFavNo;
	}

	private int portFavNo;
	
	
	

	
	

}
