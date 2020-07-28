package com.bsth.si.entity;

import java.util.Date;

/**
TABLE:.t_users                  
--------------------------------------------------------
id                   Long(19)           NOTNULL             //用户ID
username             String(20)         NOTNULL             //用户名
password             String(20)         NOTNULL             //密码
displayName          String(50)                             //昵称
realName             String(20)                             //真实姓名
birthday             Date(19)                               //生日
phone                Long(19)                               //手机号
qq                   Long(19)                               //QQ
E-mail               String(50)                             //E-mail
updateTime           Date(19)           NOTNULL             //更新时间
createTime           Date(19)           NOTNULL             //创建时间
*/
public class Users {
	private	Long id;
	private	String username;
	private	String password;
	private	String displayName;
	private	String realName;
	private	Date birthday;
	private	Long phone;
	private	Long qq;
	private	String email;
	private	Date updateTime;
	private	Date createTime;

	/**
	* id  Long(19)  NOTNULL  //用户ID    
	*/
	public Long getId(){
		return id;
	}
	
	/**
	* id  Long(19)  NOTNULL  //用户ID    
	*/
	public void setId(Long id){
		this.id = id;
	}
	/**
	* username  String(20)  NOTNULL  //用户名    
	*/
	public String getUsername(){
		return username;
	}
	
	/**
	* username  String(20)  NOTNULL  //用户名    
	*/
	public void setUsername(String username){
		this.username = username;
	}
	/**
	* password  String(20)  NOTNULL  //密码    
	*/
	public String getPassword(){
		return password;
	}
	
	/**
	* password  String(20)  NOTNULL  //密码    
	*/
	public void setPassword(String password){
		this.password = password;
	}
	/**
	* displayName  String(50)  //昵称    
	*/
	public String getDisplayName(){
		return displayName;
	}
	
	/**
	* displayName  String(50)  //昵称    
	*/
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}
	/**
	* realName  String(20)  //真实姓名    
	*/
	public String getRealName(){
		return realName;
	}
	
	/**
	* realName  String(20)  //真实姓名    
	*/
	public void setRealName(String realName){
		this.realName = realName;
	}
	/**
	* birthday  Date(19)  //生日    
	*/
	public Date getBirthday(){
		return birthday;
	}
	
	/**
	* birthday  Date(19)  //生日    
	*/
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	/**
	* phone  Long(19)  //手机号    
	*/
	public Long getPhone(){
		return phone;
	}
	
	/**
	* phone  Long(19)  //手机号    
	*/
	public void setPhone(Long phone){
		this.phone = phone;
	}
	/**
	* qq  Long(19)  //QQ    
	*/
	public Long getQq(){
		return qq;
	}
	
	/**
	* qq  Long(19)  //QQ    
	*/
	public void setQq(Long qq){
		this.qq = qq;
	}
	/**
	* E-mail  String(50)  //E-mail    
	*/
	public String getEmail(){
		return email;
	}
	
	/**
	* E-mail  String(50)  //E-mail    
	*/
	public void setEmail(String email){
		this.email = email;
	}
	/**
	* updateTime  Date(19)  NOTNULL  //更新时间    
	*/
	public Date getUpdateTime(){
		return updateTime;
	}
	
	/**
	* updateTime  Date(19)  NOTNULL  //更新时间    
	*/
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	* createTime  Date(19)  NOTNULL  //创建时间    
	*/
	public Date getCreateTime(){
		return createTime;
	}
	
	/**
	* createTime  Date(19)  NOTNULL  //创建时间    
	*/
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
}