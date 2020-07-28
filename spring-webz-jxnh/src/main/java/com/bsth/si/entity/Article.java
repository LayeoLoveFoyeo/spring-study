package com.bsth.si.entity;

import java.util.Date;

/**
TABLE:.t_article                
--------------------------------------------------------
article_id           Long(19)           NOTNULL             //文章编号
articleName          String(50)                             //文章名称
articleDress         String(100)                            //文章地址
articleClass         Long(19)                               //文章类别
createdTime          Date(19)                               //创建时间
publicTime           Date(19)                               //发布时间
articleContent       String(5000)                           //文章类容
createdBy            Long(19)                               //创建人
updateBy             Long(19)                               //更新人
updateTime           Date(19)                               //更新时间
writer               String(50)                             //作者
*/
public class Article {
	private	Long articleId;
	private	String articleName;
	private	String articleDress;
	private	Long articleClass;
	private	Date createdTime;
	private	Date publicTime;
	private	String articleContent;
	private	Long createdBy;
	private	Long updateBy;
	private	Date updateTime;
	private	String writer;

	/**
	* article_id  Long(19)  NOTNULL  //文章编号    
	*/
	public Long getArticleId(){
		return articleId;
	}
	
	/**
	* article_id  Long(19)  NOTNULL  //文章编号    
	*/
	public void setArticleId(Long articleId){
		this.articleId = articleId;
	}
	/**
	* articleName  String(50)  //文章名称    
	*/
	public String getArticleName(){
		return articleName;
	}
	
	/**
	* articleName  String(50)  //文章名称    
	*/
	public void setArticleName(String articleName){
		this.articleName = articleName;
	}
	/**
	* articleDress  String(100)  //文章地址    
	*/
	public String getArticleDress(){
		return articleDress;
	}
	
	/**
	* articleDress  String(100)  //文章地址    
	*/
	public void setArticleDress(String articleDress){
		this.articleDress = articleDress;
	}
	/**
	* articleClass  Long(19)  //文章类别    
	*/
	public Long getArticleClass(){
		return articleClass;
	}
	
	/**
	* articleClass  Long(19)  //文章类别    
	*/
	public void setArticleClass(Long articleClass){
		this.articleClass = articleClass;
	}
	/**
	* createdTime  Date(19)  //创建时间    
	*/
	public Date getCreatedTime(){
		return createdTime;
	}
	
	/**
	* createdTime  Date(19)  //创建时间    
	*/
	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
	/**
	* publicTime  Date(19)  //发布时间    
	*/
	public Date getPublicTime(){
		return publicTime;
	}
	
	/**
	* publicTime  Date(19)  //发布时间    
	*/
	public void setPublicTime(Date publicTime){
		this.publicTime = publicTime;
	}
	/**
	* articleContent  String(5000)  //文章类容    
	*/
	public String getArticleContent(){
		return articleContent;
	}
	
	/**
	* articleContent  String(5000)  //文章类容    
	*/
	public void setArticleContent(String articleContent){
		this.articleContent = articleContent;
	}
	/**
	* createdBy  Long(19)  //创建人    
	*/
	public Long getCreatedBy(){
		return createdBy;
	}
	
	/**
	* createdBy  Long(19)  //创建人    
	*/
	public void setCreatedBy(Long createdBy){
		this.createdBy = createdBy;
	}
	/**
	* updateBy  Long(19)  //更新人    
	*/
	public Long getUpdateBy(){
		return updateBy;
	}
	
	/**
	* updateBy  Long(19)  //更新人    
	*/
	public void setUpdateBy(Long updateBy){
		this.updateBy = updateBy;
	}
	/**
	* updateTime  Date(19)  //更新时间    
	*/
	public Date getUpdateTime(){
		return updateTime;
	}
	
	/**
	* updateTime  Date(19)  //更新时间    
	*/
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	* writer  String(50)  //作者    
	*/
	public String getWriter(){
		return writer;
	}
	
	/**
	* writer  String(50)  //作者    
	*/
	public void setWriter(String writer){
		this.writer = writer;
	}
}