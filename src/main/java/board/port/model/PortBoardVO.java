package board.port.model;

import java.sql.Date;
import java.util.List;

public class PortBoardVO {
	
	private int portNo;
	private String portTitle;
	private String portContent;
	private String userId;
	private Date portDate;
	private int portView;
	
	private List<PortBoardImgVO> portImgList;
	
	private PortBoardImgVO portImg;
	
	public PortBoardImgVO getPortImg() {
		return portImg;
	}
	public void setPortImg(PortBoardImgVO portImg) {
		this.portImg = portImg;
	}
	public List<PortBoardImgVO> getPortImgList() {
		return portImgList;
	}
	public void setPortImgList(List<PortBoardImgVO> portImgList) {
		this.portImgList = portImgList;
	}
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
	
	

}
