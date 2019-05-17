package com.demo.hibernate.NodeTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.demo.hibernate.dao.INodeDao;
import com.demo.hibernate.dao.NodeDao;
import com.demo.hibernate.entity.Node;
import com.demo.hibernate.util.HibernateUtil;

public class DeleteNodeTest {
	@Test
	public void save() {
		INodeDao nodeDao=new NodeDao();;
		Node node=nodeDao.findOne(1);
		System.out.println("原始数据库中的树形结构为：");
		print(node,0);
		Node middleNode=nodeDao.findOne(2);
		nodeDao.change(middleNode);
		nodeDao.detele(middleNode);
		Node node2=nodeDao.findOne(1);
		System.out.println("删除中间节点后数据库中的树形结构为：");
		print(node2, 0);
	}
	private void print(Node node,int level) {
		String pre="";
		for (int i = 0; i <level; i++) {
			pre+="------";
		}
		System.out.println(pre+node.getName());
		for(Node children:node.getChildren()) {
			print(children, level+1);
		}
	}
}
