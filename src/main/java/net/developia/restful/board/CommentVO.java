package net.developia.restful.board;

import java.io.Serializable;
import java.util.Date;

import net.developia.restful.user.UserVO;

public class CommentVO implements Serializable {
	
	private long com_no;
	private String com_content;
	private Date com_regdate;
	private int com_like;
	private int com_dislike;
	private String com_ip;
	private long art_no;
	private UserVO userVO;
	public long getCom_no() {
		return com_no;
	}
	public void setCom_no(long com_no) {
		this.com_no = com_no;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public Date getCom_regdate() {
		return com_regdate;
	}
	public void setCom_regdate(Date com_regdate) {
		this.com_regdate = com_regdate;
	}
	public int getCom_like() {
		return com_like;
	}
	public void setCom_like(int com_like) {
		this.com_like = com_like;
	}
	public int getCom_dislike() {
		return com_dislike;
	}
	public void setCom_dislike(int com_dislike) {
		this.com_dislike = com_dislike;
	}
	public String getCom_ip() {
		return com_ip;
	}
	public void setCom_ip(String com_ip) {
		this.com_ip = com_ip;
	}
	public long getArt_no() {
		return art_no;
	}
	public void setArt_no(long art_no) {
		this.art_no = art_no;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	@Override
	public String toString() {
		return "CommentVO [com_no=" + com_no + ", com_content=" + com_content + ", com_regdate=" + com_regdate
				+ ", com_like=" + com_like + ", com_dislike=" + com_dislike + ", com_ip=" + com_ip + ", art_no="
				+ art_no + ", userVO=" + userVO + "]";
	}
	
	
	

}
