package com.bsth.si.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	/**
	 * 位序
	 */
	public int id;
	/**
	 * 节点内容
	 */
	public String text;
	/**
	 * 节点链接
	 */
	public String url;

	/**
	 * 父节点编号
	 */
	public String parentId;
	/**
	 * 孩子节点列表
	 */
	private List<TreeNode> children = new ArrayList<TreeNode>();

	// 添加孩子节点
	public void addChild(TreeNode node) {
		this.children.add(node);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", text=" + text + ", url=" + url
				+ ", parentId=" + parentId + ", children=" + children + "]\n";
	}

}
