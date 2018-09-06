package net.developia.restful.board;

import java.io.Serializable;

import net.developia.restful.user.UserVO;

public class BoardVO implements Serializable {
	private int boa_no;
	private String boa_name;
	private int boa_status;
	private UserVO userVO;
	public int getBoa_no() {
		return boa_no;
	}
	public void setBoa_no(int boa_no) {
		this.boa_no = boa_no;
	}
	public String getBoa_name() {
		return boa_name;
	}
	public void setBoa_name(String boa_name) {
		this.boa_name = boa_name;
	}
	public int getBoa_status() {
		return boa_status;
	}
	public void setBoa_status(int boa_status) {
		this.boa_status = boa_status;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	@Override
	public String toString() {
		return "BoardVO [boa_no=" + boa_no + ", boa_name=" + boa_name + ", boa_status=" + boa_status + ", userVO="
				+ userVO + "]";
	}
	
	
	
}
