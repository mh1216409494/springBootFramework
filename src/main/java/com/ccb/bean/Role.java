package com.ccb.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * @Description  
 * @Author  mahuanhuan 
 * @Date 2020-12-13 
 */
public class Role  implements Serializable {
	private static final long serialVersionUID =  7404143470222710263L;

	/**
	 * 角色Id
	 */
	private Integer roleId;

	/**
	 * 角色名
	 */
	private String roleName;

	private String roleDesc;

	private String roleCode;

	private String roleState;

	private Integer createBy;

	private String createTime;

	private Integer updateBy;

	private String updateTime;

	private List<UserInfo> uList;

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleState() {
		return this.roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
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

	public List<UserInfo> getuList() {
		return uList;
	}

	public void setuList(List<UserInfo> uList) {
		this.uList = uList;
	}

	public Role() {
	}


	@Override
	public String toString() {
		return "Role{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", roleDesc='" + roleDesc + '\'' +
				", roleCode='" + roleCode + '\'' +
				", roleState='" + roleState + '\'' +
				", createBy=" + createBy +
				", createTime='" + createTime + '\'' +
				", updateBy=" + updateBy +
				", updateTime='" + updateTime + '\'' +
				", uList=" + uList +
				'}';
	}
}
