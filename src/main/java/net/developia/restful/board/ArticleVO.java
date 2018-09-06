package net.developia.restful.board;

import java.io.Serializable;
import java.util.Date;

import net.developia.restful.user.UserVO;

public class ArticleVO implements Serializable {
	private int art_no;
	private String art_title;
	private String art_content;
	private int art_like;
	private int art_dislike;
	private Date art_regdate;
	private int art_readcnt;
	private int art_com_cnt;
	private String art_ip;
	private int boa_no;
	private UserVO userVO;
	public int getArt_no() {
		return art_no;
	}
	public void setArt_no(int art_no) {
		this.art_no = art_no;
	}
	public String getArt_title() {
		return art_title;
	}
	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}
	public String getArt_content() {
		return art_content;
	}
	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}
	public int getArt_like() {
		return art_like;
	}
	public void setArt_like(int art_like) {
		this.art_like = art_like;
	}
	public int getArt_dislike() {
		return art_dislike;
	}
	public void setArt_dislike(int art_dislike) {
		this.art_dislike = art_dislike;
	}
	public Date getArt_regdate() {
		return art_regdate;
	}
	public void setArt_regdate(Date art_regdate) {
		this.art_regdate = art_regdate;
	}
	public int getArt_readcnt() {
		return art_readcnt;
	}
	public void setArt_readcnt(int art_readcnt) {
		this.art_readcnt = art_readcnt;
	}
	public int getArt_com_cnt() {
		return art_com_cnt;
	}
	public void setArt_com_cnt(int art_com_cnt) {
		this.art_com_cnt = art_com_cnt;
	}
	public String getArt_ip() {
		return art_ip;
	}
	public void setArt_ip(String art_ip) {
		this.art_ip = art_ip;
	}
	public int getBoa_no() {
		return boa_no;
	}
	public void setBoa_no(int boa_no) {
		this.boa_no = boa_no;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	@Override
	public String toString() {
		return "ArticleVO [art_no=" + art_no + ", art_title=" + art_title + ", art_content=" + art_content
				+ ", art_like=" + art_like + ", art_dislike=" + art_dislike + ", art_regdate=" + art_regdate
				+ ", art_readcnt=" + art_readcnt + ", art_com_cnt=" + art_com_cnt + ", art_ip=" + art_ip + ", boa_no="
				+ boa_no + ", userVO=" + userVO + "]";
	}

	
	
	
	
	

}
