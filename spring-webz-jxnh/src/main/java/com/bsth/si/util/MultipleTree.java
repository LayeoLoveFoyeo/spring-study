package com.bsth.si.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 多叉树类
 */
public class MultipleTree {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// 读取层次数据结果集列表
		List dataList = VirtualDataGenerator.getVirtualResult();

		// 节点列表（散列表，用于临时存储节点对象）
		HashMap TreeNodeList = new HashMap();
		// 根节点
		List rootlist = new ArrayList();
		// 根据结果集构造节点列表（存入散列表）
		for (Iterator it = dataList.iterator(); it.hasNext();) {
			Map dataRecord = (Map) it.next();
			HashMap map = new HashMap();
			map.put("id", (String) dataRecord.get("id"));
			map.put("text", (String) dataRecord.get("text"));
			map.put("parentId", (String) dataRecord.get("parentId"));
			map.put("id", (String) dataRecord.get("id"));
			TreeNodeList.put((String) dataRecord.get("id"), map);
		}
		// 构造无序的多叉树
		Set entrySet = TreeNodeList.entrySet();
		for (Iterator it = entrySet.iterator(); it.hasNext();) {
			HashMap map = (HashMap) ((Map.Entry) it.next()).getValue();
			if (map.get("parentId") == null || map.get("parentId").equals("")) {
				// root = TreeNode;
				List templist = (List) map.get("children");
				if (null == templist) {
					map.put("children", new ArrayList());
				} 
				rootlist.add(map);
			} else {
				HashMap tempmap = ((HashMap) TreeNodeList.get(map.get("parentId")));
				List templist = (List) tempmap.get("children");
				if (null != templist) {
					templist.add(map);
				} else {
					templist =  new ArrayList();
					templist.add(map);
				}
				tempmap.put("children", templist);
			}
		}
		// 输出无序的树形菜单的JSON字符串
		System.out.println(rootlist.toString());

	}
}

/**
 * 节点类
 */


/**
 * 孩子列表类
 */

/**
 * 节点比较器
 */

/**
 * 构造虚拟的层次数据
 */
class VirtualDataGenerator {
	// 构造无序的结果集列表，实际应用中，该数据应该从数据库中查询获得；
	public static List getVirtualResult() {
		List dataList = new ArrayList();

		HashMap dataRecord1 = new HashMap();
		dataRecord1.put("id", "112000");
		dataRecord1.put("text", "廊坊银行解放道支行");
		dataRecord1.put("parentId", "110000");

		HashMap dataRecord2 = new HashMap();
		dataRecord2.put("id", "112200");
		dataRecord2.put("text", "廊坊银行三大街支行");
		dataRecord2.put("parentId", "112000");

		HashMap dataRecord3 = new HashMap();
		dataRecord3.put("id", "112100");
		dataRecord3.put("text", "廊坊银行广阳道支行");
		dataRecord3.put("parentId", "112000");

		HashMap dataRecord4 = new HashMap();
		dataRecord4.put("id", "113000");
		dataRecord4.put("text", "廊坊银行开发区支行");
		dataRecord4.put("parentId", "110000");

		HashMap dataRecord5 = new HashMap();
		dataRecord5.put("id", "100000");
		dataRecord5.put("text", "廊坊银行总行");
		dataRecord5.put("parentId", "");

		HashMap dataRecord6 = new HashMap();
		dataRecord6.put("id", "110000");
		dataRecord6.put("text", "廊坊分行");
		dataRecord6.put("parentId", "100000");

		HashMap dataRecord7 = new HashMap();
		dataRecord7.put("id", "111000");
		dataRecord7.put("text", "廊坊银行金光道支行");
		dataRecord7.put("parentId", "110000");

		dataList.add(dataRecord1);
		dataList.add(dataRecord2);
		dataList.add(dataRecord3);
		dataList.add(dataRecord4);
		dataList.add(dataRecord5);
		dataList.add(dataRecord6);
		dataList.add(dataRecord7);

		return dataList;
	}
}
