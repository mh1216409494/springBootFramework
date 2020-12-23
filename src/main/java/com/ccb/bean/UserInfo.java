package com.ccb.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

import java.util.List;
/**
 * @Description  
 * @Author  mahuanhuan 
 * @Date 2020-12-13 
 */
public class UserInfo  implements Serializable {
	private static final long serialVersionUID =  5474634641916133716L;

	private Integer userId;

	private Integer groupId;

	private String nickName;

	private String userName;

	private String userCode;

	private String userPwd;

	/**
	 * 1 超级管理员 、 2  管理员 、 3 普通用户
	 */

	private String userType;

	/**
	 * 0 未审核 、1 已审核
	 */

	private String userState;

	/**
	 * 0 正常、 1 已删除
	 */
	private String isDelete;

	private Integer createBy;

	private String createTime;

	private Integer updateBy;

	private String updateTime;

	private List<Role> rList;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<Role> getrList() {
		return rList;
	}

	public void setrList(List<Role> rList) {
		this.rList = rList;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"userId=" + userId +
				", groupId=" + groupId +
				", nickName='" + nickName + '\'' +
				", userName='" + userName + '\'' +
				", userCode='" + userCode + '\'' +
				", userPwd='" + userPwd + '\'' +
				", userType='" + userType + '\'' +
				", userState='" + userState + '\'' +
				", isDelete='" + isDelete + '\'' +
				", createBy=" + createBy +
				", createTime='" + createTime + '\'' +
				", updateBy=" + updateBy +
				", updateTime='" + updateTime + '\'' +
				", rList=" + rList +
				'}';
	}
}
