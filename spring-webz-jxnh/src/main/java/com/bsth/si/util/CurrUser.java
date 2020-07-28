/**
 * @Title: CurrUser.java
 * @Package com.bsth.si.util
 * @Description: TODO
 * Copyright: Copyright (c) 2012
 * Company: 
 *
 * @author sine
 * @date 2013-2-20 下午3:22:15
 * 
 * @version V1.0
 */
package com.bsth.si.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CurrUser
 * @Description: TODO
 * @author sine
 * @date 2013-2-20 下午3:22:15
 * 
 */
public class CurrUser {
	private Long userId;
	private String userAccount;
	private String userName;
	private String userDesc;
	private String userDeptV;
	private Long isEnabled;
	private Long userDept;
	private String roleId;
	
	private String reminMessage1;
	private  String reminMessage2;
	private  String reminMessage3;
	
	
	public String getReminMessage3() {
		return reminMessage3;
	}

	public void setReminMessage3(String reminMessage3) {
		this.reminMessage3 = reminMessage3;
	}

	public String getReminMessage2() {
		return reminMessage2;
	}

	public void setReminMessage2(String reminMessage2) {
		this.reminMessage2 = reminMessage2;
	}

	private List<String> menuUrls = new ArrayList<String>();

	public String getUserDeptV() {
		return userDeptV;
	}

	public void setUserDeptV(String userDeptV) {
		this.userDeptV = userDeptV;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Long getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Long isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getUserDept() {
		return userDept;
	}

	public void setUserDept(Long userDept) {
		this.userDept = userDept;
	}

	public List<String> getMenuUrls() {
		return menuUrls;
	}

	public void setMenuUrls(List<String> menuUrls) {
		this.menuUrls = menuUrls;
	}

	public String getReminMessage1() {
		return reminMessage1;
	}

	public void setReminMessage1(String reminMessage1) {
		this.reminMessage1 = reminMessage1;
	}

}
