package com.ccb.bean;

import javax.management.relation.RoleInfo;
import java.io.Serializable;

/**
 * @Description  
 * @Author  mahuanhuan 
 * @Date 2020-12-13 
 */
public class UserRole  implements Serializable {
	private static final long serialVersionUID =  1989980573613093705L;

	private Integer userRoleId;

	private Integer roleId;

	private Integer userId;

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"userRoleId=" + userRoleId +
				", roleId=" + roleId +
				", userId=" + userId +
				'}';
	}
}
