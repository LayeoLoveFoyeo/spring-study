package com.bsth.si.entity;

import java.util.Date;

/**
TABLE:.t_productionclass        
--------------------------------------------------------
id                   Long(19)           NOTNULL             //商品类别编号
level                Long(19)           NOTNULL             //分类等级
fatherNode           Long(19)                               //父节点
nodeId               Long(19)           NOTNULL             //节点编号
className            String(50)         NOTNULL             //类别称
*/
public class Productionclass {
	private	Long id;
	private	Long level;
	private	Long fatherNode;
	private	Long nodeId;
	private	String className;

	/**
	* id  Long(19)  NOTNULL  //商品类别编号    
	*/
	public Long getId(){
		return id;
	}
	
	/**
	* id  Long(19)  NOTNULL  //商品类别编号    
	*/
	public void setId(Long id){
		this.id = id;
	}
	/**
	* level  Long(19)  NOTNULL  //分类等级    
	*/
	public Long getLevel(){
		return level;
	}
	
	/**
	* level  Long(19)  NOTNULL  //分类等级    
	*/
	public void setLevel(Long level){
		this.level = level;
	}
	/**
	* fatherNode  Long(19)  //父节点    
	*/
	public Long getFatherNode(){
		return fatherNode;
	}
	
	/**
	* fatherNode  Long(19)  //父节点    
	*/
	public void setFatherNode(Long fatherNode){
		this.fatherNode = fatherNode;
	}
	/**
	* nodeId  Long(19)  NOTNULL  //节点编号    
	*/
	public Long getNodeId(){
		return nodeId;
	}
	
	/**
	* nodeId  Long(19)  NOTNULL  //节点编号    
	*/
	public void setNodeId(Long nodeId){
		this.nodeId = nodeId;
	}
	/**
	* className  String(50)  NOTNULL  //类别称    
	*/
	public String getClassName(){
		return className;
	}
	
	/**
	* className  String(50)  NOTNULL  //类别称    
	*/
	public void setClassName(String className){
		this.className = className;
	}
}