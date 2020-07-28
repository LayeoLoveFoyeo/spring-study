package com.bsth.si.entity;

import java.util.Date;

/**
TABLE:.t_leamess                
--------------------------------------------------------
leaMess_id           Long(19)           NOTNULL             //留言编号
leaMessContent       String(500)                            //留言内容
leaMessTime          Date(19)                               //留言时间
leaMessIP            String(50)                             //
ansContent           String(500)                            //留言回复时间
ansTime              Date(19)                               //留言回复时间
*/
public class Leamess {
	private	Long leaMessId;
	private	String leaMessContent;
	private	Date leaMessTime;
	private	String leaMessIp;
	private	String ansContent;
	private	Date ansTime;

	/**
	* leaMess_id  Long(19)  NOTNULL  //留言编号    
	*/
	public Long getLeaMessId(){
		return leaMessId;
	}
	
	/**
	* leaMess_id  Long(19)  NOTNULL  //留言编号    
	*/
	public void setLeaMessId(Long leaMessId){
		this.leaMessId = leaMessId;
	}
	/**
	* leaMessContent  String(500)  //留言内容    
	*/
	public String getLeaMessContent(){
		return leaMessContent;
	}
	
	/**
	* leaMessContent  String(500)  //留言内容    
	*/
	public void setLeaMessContent(String leaMessContent){
		this.leaMessContent = leaMessContent;
	}
	/**
	* leaMessTime  Date(19)  //留言时间    
	*/
	public Date getLeaMessTime(){
		return leaMessTime;
	}
	
	/**
	* leaMessTime  Date(19)  //留言时间    
	*/
	public void setLeaMessTime(Date leaMessTime){
		this.leaMessTime = leaMessTime;
	}
	/**
	* leaMessIP  String(50)  //    
	*/
	public String getLeaMessIp(){
		return leaMessIp;
	}
	
	/**
	* leaMessIP  String(50)  //    
	*/
	public void setLeaMessIp(String leaMessIp){
		this.leaMessIp = leaMessIp;
	}
	/**
	* ansContent  String(500)  //留言回复时间    
	*/
	public String getAnsContent(){
		return ansContent;
	}
	
	/**
	* ansContent  String(500)  //留言回复时间    
	*/
	public void setAnsContent(String ansContent){
		this.ansContent = ansContent;
	}
	/**
	* ansTime  Date(19)  //留言回复时间    
	*/
	public Date getAnsTime(){
		return ansTime;
	}
	
	/**
	* ansTime  Date(19)  //留言回复时间    
	*/
	public void setAnsTime(Date ansTime){
		this.ansTime = ansTime;
	}
}