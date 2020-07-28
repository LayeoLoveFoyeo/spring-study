package com.bsth.si.entity;

import java.util.Date;

/**
TABLE:.t_production             
--------------------------------------------------------
id                   Long(19)           NOTNULL             //产品编号
proName              String(50)         NOTNULL             //产品名称
proClass             Long(19)                               //商品类别
ripeTime             String(20)                             //销售时间段
cropper              Long(19)                               //产品库存
price                String(20)                             //价格
publishTime          Date(19)                               //发布日期
*/
public class Production {
	private	Long id;
	private	String proName;
	private	Long proClass;
	private	String ripeTime;
	private	Long cropper;
	private	String price;
	private	Date publishTime;

	/**
	* id  Long(19)  NOTNULL  //产品编号    
	*/
	public Long getId(){
		return id;
	}
	
	/**
	* id  Long(19)  NOTNULL  //产品编号    
	*/
	public void setId(Long id){
		this.id = id;
	}
	/**
	* proName  String(50)  NOTNULL  //产品名称    
	*/
	public String getProName(){
		return proName;
	}
	
	/**
	* proName  String(50)  NOTNULL  //产品名称    
	*/
	public void setProName(String proName){
		this.proName = proName;
	}
	/**
	* proClass  Long(19)  //商品类别    
	*/
	public Long getProClass(){
		return proClass;
	}
	
	/**
	* proClass  Long(19)  //商品类别    
	*/
	public void setProClass(Long proClass){
		this.proClass = proClass;
	}
	/**
	* ripeTime  String(20)  //销售时间段    
	*/
	public String getRipeTime(){
		return ripeTime;
	}
	
	/**
	* ripeTime  String(20)  //销售时间段    
	*/
	public void setRipeTime(String ripeTime){
		this.ripeTime = ripeTime;
	}
	/**
	* cropper  Long(19)  //产品库存    
	*/
	public Long getCropper(){
		return cropper;
	}
	
	/**
	* cropper  Long(19)  //产品库存    
	*/
	public void setCropper(Long cropper){
		this.cropper = cropper;
	}
	/**
	* price  String(20)  //价格    
	*/
	public String getPrice(){
		return price;
	}
	
	/**
	* price  String(20)  //价格    
	*/
	public void setPrice(String price){
		this.price = price;
	}
	/**
	* publishTime  Date(19)  //发布日期    
	*/
	public Date getPublishTime(){
		return publishTime;
	}
	
	/**
	* publishTime  Date(19)  //发布日期    
	*/
	public void setPublishTime(Date publishTime){
		this.publishTime = publishTime;
	}
}